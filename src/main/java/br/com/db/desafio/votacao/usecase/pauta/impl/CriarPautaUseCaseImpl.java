package br.com.db.desafio.votacao.usecase.pauta.impl;

import br.com.db.desafio.votacao.controller.pauta.dto.AssembleiaResponseDto;
import br.com.db.desafio.votacao.controller.pauta.dto.PautaRequestDto;
import br.com.db.desafio.votacao.controller.sessao.dto.SessaoDto;
import br.com.db.desafio.votacao.repository.PautaRepository;
import br.com.db.desafio.votacao.usecase.pauta.CriarPautaUseCase;
import br.com.db.desafio.votacao.usecase.pauta.PautaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarPautaUseCaseImpl implements CriarPautaUseCase {

    private final PautaMapper pautaMapper;
    private final PautaRepository pautaRepository;

    @Override
    public AssembleiaResponseDto criar(PautaRequestDto request, SessaoDto sessaoDto) {

        var pauta = pautaMapper.mapToPauta(request, sessaoDto);
        var pautaSalva = pautaRepository.save(pauta);

        return pautaMapper.mapToPautaResponseDto(pautaSalva);
    }
}
