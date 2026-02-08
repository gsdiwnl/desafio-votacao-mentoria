package br.com.db.desafio.votacao.controller.pauta;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResultadoPautaResponseDto {

    private Long totalFavor;
    private Long totalContra;
    private String resultado;
}
