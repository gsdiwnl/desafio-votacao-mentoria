package br.com.db.desafio.votacao.usecase.pauta;

import br.com.db.desafio.votacao.controller.pauta.dto.AssembleiaResponseDto;

import java.util.Collection;

public interface BuscarPautaUseCase {

    AssembleiaResponseDto buscar(Long id);
    Collection<AssembleiaResponseDto> buscarTodas();
}
