package br.com.db.desafio.votacao.usecase.sessao;

import br.com.db.desafio.votacao.controller.sessao.dto.SessaoResponseDto;
import br.com.db.desafio.votacao.controller.sessao.dto.StatusSessaoResponseDto;

public interface StatusSessaoUseCase {

    StatusSessaoResponseDto consultar(Long id);
    SessaoResponseDto encerrar(Long id);
}
