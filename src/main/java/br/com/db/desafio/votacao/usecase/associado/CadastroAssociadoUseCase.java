package br.com.db.desafio.votacao.usecase.associado;

import br.com.db.desafio.votacao.controller.associado.AssociadoRequestDto;
import br.com.db.desafio.votacao.controller.associado.AssociadoResponseDto;

public interface CadastroAssociadoUseCase {

    AssociadoResponseDto cadastrar(AssociadoRequestDto associadoRequestDto);
}
