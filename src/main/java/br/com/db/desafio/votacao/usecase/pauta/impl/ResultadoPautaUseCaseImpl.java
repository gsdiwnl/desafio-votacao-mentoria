package br.com.db.desafio.votacao.usecase.pauta.impl;

import br.com.db.desafio.votacao.controller.pauta.dto.ResultadoPautaResponseDto;
import br.com.db.desafio.votacao.repository.VotoRepository;
import br.com.db.desafio.votacao.service.PautaService;
import br.com.db.desafio.votacao.usecase.pauta.ResultadoPautaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultadoPautaUseCaseImpl implements ResultadoPautaUseCase {

    private final VotoRepository votoRepository;
    private final PautaService pautaService;

    @Override
    public ResultadoPautaResponseDto calcular(Long id) {

        var votosPauta = votoRepository.findByPautaId(id);

        return pautaService.calcularResultado(votosPauta);
    }
}
