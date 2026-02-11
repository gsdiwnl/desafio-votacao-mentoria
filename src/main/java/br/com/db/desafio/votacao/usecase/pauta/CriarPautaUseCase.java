package br.com.db.desafio.votacao.usecase.pauta;

import br.com.db.desafio.votacao.controller.pauta.dto.PautaRequestDto;
import br.com.db.desafio.votacao.controller.pauta.dto.PautaResponseDto;

public interface CriarPautaUseCase {

    PautaResponseDto criar(PautaRequestDto request);
}
