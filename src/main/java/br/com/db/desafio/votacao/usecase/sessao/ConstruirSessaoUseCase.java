package br.com.db.desafio.votacao.usecase.sessao;

import br.com.db.desafio.votacao.controller.sessao.dto.SessaoDto;

public interface ConstruirSessaoUseCase {

    SessaoDto construir(Integer duracao);
}
