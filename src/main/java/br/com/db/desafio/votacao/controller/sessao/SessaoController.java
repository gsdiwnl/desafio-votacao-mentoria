package br.com.db.desafio.votacao.controller.sessao;

import br.com.db.desafio.votacao.controller.sessao.dto.SessaoResponseDto;
import br.com.db.desafio.votacao.controller.sessao.dto.StatusSessaoResponseDto;
import br.com.db.desafio.votacao.usecase.sessao.StatusSessaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/sessoes")
@RequiredArgsConstructor
public class SessaoController {

    private final StatusSessaoUseCase statusPautaUseCase;

    @GetMapping("/status/{id}")
    public ResponseEntity<StatusSessaoResponseDto> verificarStatus(@PathVariable Long id) {

        StatusSessaoResponseDto response = statusPautaUseCase.consultar(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/encerrar/{id}")
    public ResponseEntity<SessaoResponseDto> encerrarSessao(@PathVariable Long id) {

        SessaoResponseDto response = statusPautaUseCase.encerrar(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
