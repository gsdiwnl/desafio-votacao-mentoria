package br.com.db.desafio.votacao.usecase.pauta;

import br.com.db.desafio.votacao.controller.pauta.dto.PautaResponseDto;

import java.util.Collection;

public interface BuscarPautaUseCase {

    PautaResponseDto buscar(Long id);
    Collection<PautaResponseDto> buscarTodas();
}
