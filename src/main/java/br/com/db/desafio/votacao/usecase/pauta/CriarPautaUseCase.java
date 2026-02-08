package br.com.db.desafio.votacao.usecase.pauta;

import br.com.db.desafio.votacao.controller.pauta.PautaRequestDto;
import br.com.db.desafio.votacao.controller.pauta.PautaResponseDto;

public interface CriarPautaUseCase {

    PautaResponseDto criar(PautaRequestDto request);
}
