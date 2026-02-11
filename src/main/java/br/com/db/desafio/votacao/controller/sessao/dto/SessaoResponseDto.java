package br.com.db.desafio.votacao.controller.sessao.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class SessaoResponseDto {

    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String status;
}
