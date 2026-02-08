package br.com.db.desafio.votacao.controller.associado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AssociadoRequestDto(

        String nome,

        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
                message = "CPF inválido! O formato deve ser XXX.XXX.XXX-XX")
        @NotBlank(message = "CPF obrigatório!")
        String cpf
) {
}
