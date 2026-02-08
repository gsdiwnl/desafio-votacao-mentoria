package br.com.db.desafio.votacao.usecase.sessao;

import br.com.db.desafio.votacao.controller.sessao.SessaoResponseDto;
import br.com.db.desafio.votacao.controller.sessao.StatusSessaoResponseDto;

public interface StatusSessaoUseCase {

    StatusSessaoResponseDto consultar(Long id);
    SessaoResponseDto encerrar(Long id);
}
