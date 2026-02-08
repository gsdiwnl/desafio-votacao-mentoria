package br.com.db.desafio.votacao.controller.sessao;

import br.com.db.desafio.votacao.model.sessao.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StatusSessaoResponseDto {

    private Status status;
}
