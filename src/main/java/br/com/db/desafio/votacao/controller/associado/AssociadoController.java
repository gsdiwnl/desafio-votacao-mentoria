package br.com.db.desafio.votacao.controller.associado;

import br.com.db.desafio.votacao.usecase.associado.CadastroAssociadoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/associados")
@RequiredArgsConstructor
public class AssociadoController {

    private final CadastroAssociadoUseCase cadastroAssociadoUseCase;

    @PostMapping
    public ResponseEntity<AssociadoResponseDto> cadastrarAssociado(@Valid @RequestBody AssociadoRequestDto request) {

        var response = cadastroAssociadoUseCase.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
