package br.com.db.desafio.votacao.usecase.voto.impl;

import br.com.db.desafio.votacao.controller.voto.dto.VotoRequestDto;
import br.com.db.desafio.votacao.controller.voto.dto.VotoResponseDto;
import br.com.db.desafio.votacao.exception.ResourceNotFoundException;
import br.com.db.desafio.votacao.model.pauta.Pauta;
import br.com.db.desafio.votacao.model.voto.Voto;
import br.com.db.desafio.votacao.repository.PautaRepository;
import br.com.db.desafio.votacao.repository.VotoRepository;
import br.com.db.desafio.votacao.service.validador.OrquestradorValidacao;
import br.com.db.desafio.votacao.service.validador.ValidadorMapper;
import br.com.db.desafio.votacao.usecase.voto.VotoMapper;
import br.com.db.desafio.votacao.usecase.voto.VotoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static br.com.db.desafio.votacao.service.validador.EtapasValidacao.VOTACAO;

@Service
@RequiredArgsConstructor
public class VotoUseCaseImpl implements VotoUseCase {

    private final PautaRepository pautaRepository;
    private final VotoRepository votoRepository;

    private final ValidadorMapper validadorMapper;
    private final VotoMapper votoMapper;

    private final OrquestradorValidacao orquestradorValidacao;

    @Override
    public VotoResponseDto votar(Long idPauta, VotoRequestDto request) {

        var pauta = buscarPauta(idPauta);
        var validacao = validadorMapper.toValidacao(request, pauta);

        orquestradorValidacao.executarValidacoes(validacao, VOTACAO.getValidadores());

        var voto = salvarVoto(request, pauta);

        return votoMapper.toVotoResponseDto(voto);
    }

    private Pauta buscarPauta(Long idPauta) {

        return pautaRepository.findById(idPauta)
                .orElseThrow(() -> new ResourceNotFoundException("Pauta não encontrada para o ID: " + idPauta));
    }

    private Voto salvarVoto(VotoRequestDto request, Pauta pauta) {

        var voto = votoMapper.toVoto(request, pauta, LocalDateTime.now());
        return votoRepository.save(voto);
    }
}
