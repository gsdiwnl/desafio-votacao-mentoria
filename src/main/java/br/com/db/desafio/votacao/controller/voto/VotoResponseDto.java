package br.com.db.desafio.votacao.controller.voto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VotoResponseDto {

    String id;
    String cpfAssociado;
    String situacao;
}
