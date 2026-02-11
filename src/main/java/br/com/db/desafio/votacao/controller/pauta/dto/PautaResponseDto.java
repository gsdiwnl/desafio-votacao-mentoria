package br.com.db.desafio.votacao.controller.pauta.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PautaResponseDto {

    private Long id;
    private LocalDateTime fimSessao;
}
