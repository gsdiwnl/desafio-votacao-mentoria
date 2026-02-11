package br.com.db.desafio.votacao.controller.pauta;

import br.com.db.desafio.votacao.controller.pauta.dto.PautaRequestDto;
import br.com.db.desafio.votacao.controller.pauta.dto.PautaResponseDto;
import br.com.db.desafio.votacao.controller.pauta.dto.ResultadoPautaResponseDto;
import br.com.db.desafio.votacao.usecase.pauta.BuscarPautaUseCase;
import br.com.db.desafio.votacao.usecase.pauta.CriarPautaUseCase;
import br.com.db.desafio.votacao.usecase.pauta.ResultadoPautaUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("v1/pautas")
@RequiredArgsConstructor
public class PautaController {

    private final CriarPautaUseCase criarPautaUseCase;
    private final BuscarPautaUseCase buscarPautaUseCase;
    private final ResultadoPautaUseCase resultadoPautaUseCase;

    @PostMapping
    public ResponseEntity<PautaResponseDto> criarPauta(@Valid @RequestBody PautaRequestDto request) {

        var response = criarPautaUseCase.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PautaResponseDto> obterPauta(@PathVariable Long id) {

        var response = buscarPautaUseCase.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<Collection<PautaResponseDto>> obterPautas() {

        var response = buscarPautaUseCase.buscarTodas();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}/resultado")
    public ResponseEntity<ResultadoPautaResponseDto> obterResultado(@PathVariable Long id) {

        var response = resultadoPautaUseCase.calcular(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
