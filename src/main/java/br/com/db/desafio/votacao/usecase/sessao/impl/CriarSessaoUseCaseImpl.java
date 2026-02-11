package br.com.db.desafio.votacao.usecase.sessao.impl;

import br.com.db.desafio.votacao.controller.sessao.dto.SessaoDto;
import br.com.db.desafio.votacao.service.SessaoService;
import br.com.db.desafio.votacao.usecase.sessao.CriarSessaoUseCase;
import br.com.db.desafio.votacao.usecase.sessao.SessaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarSessaoUseCaseImpl implements CriarSessaoUseCase {

    private final SessaoService sessaoService;
    private final SessaoMapper sessaoMapper;

    @Override
    public SessaoDto criar(Integer duracao) {

        var fimSessao = sessaoService.calcularFim(duracao);

        return sessaoMapper.mapToSessaoDto(fimSessao);
    }
}
