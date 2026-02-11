package br.com.db.desafio.votacao.controller.sessao;

import br.com.db.desafio.votacao.controller.sessao.dto.SessaoResponseDto;
import br.com.db.desafio.votacao.controller.sessao.dto.StatusSessaoResponseDto;
import br.com.db.desafio.votacao.usecase.sessao.ConsultarStatusSessaoUseCase;
import br.com.db.desafio.votacao.usecase.sessao.EncerrarSessaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/sessoes")
@RequiredArgsConstructor
public class SessaoController {

    private final ConsultarStatusSessaoUseCase consultarStatusSessaoUseCase;
    private final EncerrarSessaoUseCase encerrarSessaoUseCase;

    @GetMapping("/status/{id}")
    public ResponseEntity<StatusSessaoResponseDto> verificarStatus(@PathVariable Long id) {

        StatusSessaoResponseDto response = consultarStatusSessaoUseCase.consultar(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/encerrar/{id}")
    public ResponseEntity<SessaoResponseDto> encerrarSessao(@PathVariable Long id) {

        SessaoResponseDto response = encerrarSessaoUseCase.encerrar(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
