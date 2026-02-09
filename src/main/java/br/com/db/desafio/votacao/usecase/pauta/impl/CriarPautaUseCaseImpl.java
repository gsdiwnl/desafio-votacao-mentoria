package br.com.db.desafio.votacao.usecase.pauta.impl;

import br.com.db.desafio.votacao.controller.pauta.PautaMapper;
import br.com.db.desafio.votacao.controller.pauta.PautaRequestDto;
import br.com.db.desafio.votacao.controller.pauta.PautaResponseDto;
import br.com.db.desafio.votacao.repository.PautaRepository;
import br.com.db.desafio.votacao.usecase.pauta.CriarPautaUseCase;
import br.com.db.desafio.votacao.usecase.sessao.CriarSessaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarPautaUseCaseImpl implements CriarPautaUseCase {

    private final PautaMapper pautaMapper;
    private final PautaRepository pautaRepository;

    private final CriarSessaoUseCase criarSessaoUseCase;

    @Override
    public PautaResponseDto criar(PautaRequestDto request) {

        var sessaoDto = criarSessaoUseCase.criar(request.duracao());

        var pauta = pautaMapper.mapToPauta(request, sessaoDto);
        var pautaSalva = pautaRepository.save(pauta);

        return pautaMapper.mapToPautaResponseDto(pautaSalva);
    }
}
