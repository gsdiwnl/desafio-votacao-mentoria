package br.com.db.desafio.votacao.controller.sessao.dto;

import br.com.db.desafio.votacao.model.sessao.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class SessaoDto {

    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Status status;
}
