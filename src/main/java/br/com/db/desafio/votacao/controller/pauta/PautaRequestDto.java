package br.com.db.desafio.votacao.controller.pauta;

import jakarta.validation.constraints.NotBlank;

public record PautaRequestDto(

    @NotBlank(message = "Título obrigatório!")
    String titulo,

    @NotBlank(message = "Descrição obrigatória!")
    String descricao,

    Integer duracao
) {

}
