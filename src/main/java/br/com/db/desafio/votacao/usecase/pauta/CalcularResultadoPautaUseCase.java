package br.com.db.desafio.votacao.usecase.pauta;

import br.com.db.desafio.votacao.controller.pauta.dto.ResultadoPautaResponseDto;

public interface CalcularResultadoPautaUseCase {

    ResultadoPautaResponseDto calcular(Long id);
}
