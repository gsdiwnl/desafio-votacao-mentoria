package br.com.db.desafio.votacao.usecase.pauta.impl;

import br.com.db.desafio.votacao.controller.pauta.PautaMapper;
import br.com.db.desafio.votacao.controller.pauta.PautaResponseDto;
import br.com.db.desafio.votacao.exception.ResourceNotFoundException;
import br.com.db.desafio.votacao.repository.PautaRepository;
import br.com.db.desafio.votacao.usecase.pauta.BuscarPautaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BuscarPautaUseCaseImpl implements BuscarPautaUseCase {

    private final PautaRepository pautaRepository;
    private final PautaMapper pautaMapper;

    @Override
    public PautaResponseDto buscar(Long id) {

        var pauta = pautaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pauta não encontrada para o ID: " + id));

        return pautaMapper.mapToPautaResponseDto(pauta);
    }

    @Override
    public Collection<PautaResponseDto> buscarTodas() {

        var pautas = pautaRepository.findAll();

        return pautas.stream()
                .map(pautaMapper::mapToPautaResponseDto)
                .toList();
    }
}
