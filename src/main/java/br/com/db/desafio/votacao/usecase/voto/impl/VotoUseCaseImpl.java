package br.com.db.desafio.votacao.usecase.voto.impl;

import br.com.db.desafio.votacao.controller.sessao.SessaoMapper;
import br.com.db.desafio.votacao.controller.voto.VotoMapper;
import br.com.db.desafio.votacao.controller.voto.VotoRequestDto;
import br.com.db.desafio.votacao.controller.voto.VotoResponseDto;
import br.com.db.desafio.votacao.exception.InvalidVoteException;
import br.com.db.desafio.votacao.exception.ResourceNotFoundException;
import br.com.db.desafio.votacao.model.sessao.Status;
import br.com.db.desafio.votacao.model.voto.SituacaoVoto;
import br.com.db.desafio.votacao.repository.AssociadoRepository;
import br.com.db.desafio.votacao.repository.PautaRepository;
import br.com.db.desafio.votacao.repository.SessaoRepository;
import br.com.db.desafio.votacao.repository.VotoRepository;
import br.com.db.desafio.votacao.service.ValidadorAssociadoService;
import br.com.db.desafio.votacao.service.ValidadorSessaoService;
import br.com.db.desafio.votacao.service.ValidadorVotoService;
import br.com.db.desafio.votacao.usecase.voto.VotoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VotoUseCaseImpl implements VotoUseCase {


    private final ValidadorVotoService validadorVotoService;
    private final ValidadorSessaoService validadorSessaoService;
    private final ValidadorAssociadoService validadorAssociadoService;

    private final VotoRepository votoRepository;
    private final PautaRepository pautaRepository;
    private final AssociadoRepository associadoRepository;
    private final SessaoRepository sessaoRepository;

    private final SessaoMapper sessaoMapper;
    private final VotoMapper votoMapper;

    @Override
    public VotoResponseDto votar(Long idPauta, VotoRequestDto request) {

        var votos = votoRepository.findByPautaId(idPauta);

        if (!validadorVotoService.isVotoValido(SituacaoVoto.valueOf(request.voto()))) {
            throw new InvalidVoteException("Voto deve ser SIM ou NAO!");
        }

        if (!validadorVotoService.isVotoDuplicado(votos, request.cpfAssociado())) {
            throw new InvalidVoteException("Associado já votou nessa pauta!");
        }

        var pauta = pautaRepository.findById(idPauta)
                .orElseThrow(() -> new ResourceNotFoundException("Pauta não encontrada para o ID: " + idPauta));

        if (validadorSessaoService.isSessaoEncerrada(pauta.getSessao())) {

            var sessao = sessaoMapper.toSessao(pauta.getSessao(), Status.ENCERRADA);
            sessaoRepository.save(sessao);

            throw new InvalidVoteException("Sessão de votação não está aberta!");
        }

        if (!validadorAssociadoService.podeVotar(associadoRepository.findByCpf(request.cpfAssociado()))) {

            throw new InvalidVoteException("Associado não pode votar!");
        }

        var voto = votoMapper.toVoto(request, pauta, LocalDateTime.now());
        votoRepository.save(voto);

        return votoMapper.toVotoResponseDto(voto);
    }
}
