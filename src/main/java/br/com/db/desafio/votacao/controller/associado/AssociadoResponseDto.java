package br.com.db.desafio.votacao.controller.associado;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AssociadoResponseDto {

    String id;
    String cpf;
    String nome;
    String status;
}
