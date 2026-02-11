package br.com.db.desafio.votacao.usecase.voto;

import br.com.db.desafio.votacao.controller.voto.dto.VotoRequestDto;
import br.com.db.desafio.votacao.controller.voto.dto.VotoResponseDto;

public interface RealizarVotoUseCase {

    VotoResponseDto votar(Long idPauta, VotoRequestDto request);
}
