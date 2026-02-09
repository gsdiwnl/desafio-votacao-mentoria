package br.com.db.desafio.votacao.service;

import br.com.db.desafio.votacao.controller.pauta.PautaMapper;
import br.com.db.desafio.votacao.controller.pauta.ResultadoPautaResponseDto;
import br.com.db.desafio.votacao.model.voto.Voto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PautaService {

    private final PautaMapper pautaMapper;

    public ResultadoPautaResponseDto calcularResultado(Collection<Voto> votos) {

        var totalFavor = votos.stream().filter(v -> v.getSituacao().name().equals("SIM")).count();
        var totalContra = votos.stream().filter(v -> v.getSituacao().name().equals("NAO")).count();

        var resultado = determinarResultado(totalFavor, totalContra);

        return pautaMapper.mapToPautaResponseDto(totalFavor, totalContra, resultado);
    }

    private String determinarResultado(Long totalFavor, Long totalContra) {

        if (totalFavor > totalContra) {
            return "APROVADO";
        } else if (totalFavor < totalContra) {
            return "REJEITADO";
        } else {
            return "EMPATE";
        }
    }
}
