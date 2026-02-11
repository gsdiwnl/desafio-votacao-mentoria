package br.com.db.desafio.votacao.usecase.associado;

import br.com.db.desafio.votacao.controller.associado.dto.AssociadoRequestDto;
import br.com.db.desafio.votacao.controller.associado.dto.AssociadoResponseDto;

public interface CadastroAssociadoUseCase {

    AssociadoResponseDto cadastrar(AssociadoRequestDto associadoRequestDto);
}
