package br.com.db.desafio.votacao.usecase.sessao.impl;

import br.com.db.desafio.votacao.controller.sessao.dto.SessaoDto;
import br.com.db.desafio.votacao.service.SessaoService;
import br.com.db.desafio.votacao.usecase.sessao.ConstruirSessaoUseCase;
import br.com.db.desafio.votacao.usecase.sessao.SessaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConstruirSessaoUseCaseImpl implements ConstruirSessaoUseCase {

    private final SessaoService sessaoService;
    private final SessaoMapper sessaoMapper;

    @Override
    public SessaoDto construir(Integer duracao) {

        var fimSessao = sessaoService.calcularFim(duracao);

        return sessaoMapper.mapToSessaoDto(fimSessao);
    }
}
