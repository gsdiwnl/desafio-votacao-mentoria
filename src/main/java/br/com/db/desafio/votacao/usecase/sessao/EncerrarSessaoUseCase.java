package br.com.db.desafio.votacao.usecase.sessao;

import br.com.db.desafio.votacao.controller.sessao.dto.SessaoResponseDto;

public interface EncerrarSessaoUseCase {

    SessaoResponseDto encerrar(Long id);
}
