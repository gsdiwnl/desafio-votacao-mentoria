package br.com.db.desafio.votacao.usecase.sessao;

import br.com.db.desafio.votacao.controller.sessao.SessaoDto;

public interface CriarSessaoUseCase {

    SessaoDto criar(Integer duracao);
}
