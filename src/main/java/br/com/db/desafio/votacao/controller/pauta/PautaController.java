package br.com.db.desafio.votacao.controller.pauta;

import br.com.db.desafio.votacao.controller.pauta.dto.AssembleiaResponseDto;
import br.com.db.desafio.votacao.controller.pauta.dto.PautaRequestDto;
import br.com.db.desafio.votacao.controller.pauta.dto.ResultadoPautaResponseDto;
import br.com.db.desafio.votacao.usecase.assembleia.ConstruirAssembleiaUseCase;
import br.com.db.desafio.votacao.usecase.pauta.BuscarPautaUseCase;
import br.com.db.desafio.votacao.usecase.pauta.CalcularResultadoPautaUseCase;
import br.com.db.desafio.votacao.usecase.pauta.CriarPautaUseCase;
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
    private final ConstruirAssembleiaUseCase construirAssembleiaUseCase;
    private final CalcularResultadoPautaUseCase calcularResultadoPautaUseCase;

    @PostMapping
    public ResponseEntity<AssembleiaResponseDto> criarPauta(@Valid @RequestBody PautaRequestDto request) {

        var response = construirAssembleiaUseCase.construir(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssembleiaResponseDto> obterPauta(@PathVariable Long id) {

        var response = buscarPautaUseCase.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<Collection<AssembleiaResponseDto>> obterPautas() {

        var response = buscarPautaUseCase.buscarTodas();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}/resultado")
    public ResponseEntity<ResultadoPautaResponseDto> obterResultado(@PathVariable Long id) {

        var response = calcularResultadoPautaUseCase.calcular(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
