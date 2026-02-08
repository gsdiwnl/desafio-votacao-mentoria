package br.com.db.desafio.votacao.usecase.pauta.impl;

import br.com.db.desafio.votacao.controller.pauta.PautaMapper;
import br.com.db.desafio.votacao.controller.pauta.PautaRequestDto;
import br.com.db.desafio.votacao.controller.pauta.PautaResponseDto;
import br.com.db.desafio.votacao.repository.PautaRepository;
import br.com.db.desafio.votacao.service.SessaoService;
import br.com.db.desafio.votacao.usecase.pauta.CriarPautaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarPautaUseCaseImpl implements CriarPautaUseCase {

    private final SessaoService sessaoService;
    private final PautaRepository pautaRepository;
    private final PautaMapper pautaMapper;

    @Override
    public PautaResponseDto criar(PautaRequestDto request) {

        // TODO: criar Sessao e enviar como parametro pro mapper
        var fimSessao = sessaoService.calcularFim(request.duracao());

        var pauta = pautaMapper.mapToPauta(request, fimSessao);
        var pautaSalva = pautaRepository.save(pauta);

        return pautaMapper.mapToPautaResponseDto(pautaSalva);
    }
}
