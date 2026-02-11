package br.com.db.desafio.votacao.controller.voto;

import br.com.db.desafio.votacao.controller.voto.dto.VotoRequestDto;
import br.com.db.desafio.votacao.controller.voto.dto.VotoResponseDto;
import br.com.db.desafio.votacao.usecase.voto.VotoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/votos")
@RequiredArgsConstructor
public class VotoController {

    private final VotoUseCase votoUseCase;

    @PostMapping("/{idPauta}/votar")
    public ResponseEntity<VotoResponseDto> realizarVoto(
            @PathVariable Long idPauta,
            @RequestBody VotoRequestDto request) {

        var response = votoUseCase.votar(idPauta, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
