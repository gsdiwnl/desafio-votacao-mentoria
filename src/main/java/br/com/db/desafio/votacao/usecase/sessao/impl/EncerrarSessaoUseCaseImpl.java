package br.com.db.desafio.votacao.usecase.sessao.impl;

import br.com.db.desafio.votacao.controller.sessao.dto.SessaoResponseDto;
import br.com.db.desafio.votacao.exception.ResourceNotFoundException;
import br.com.db.desafio.votacao.repository.SessaoRepository;
import br.com.db.desafio.votacao.usecase.sessao.EncerrarSessaoUseCase;
import br.com.db.desafio.votacao.usecase.sessao.SessaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncerrarSessaoUseCaseImpl implements EncerrarSessaoUseCase {

    private final SessaoRepository sessaoRepository;
    private final SessaoMapper sessaoMapper;

    @Override
    public SessaoResponseDto encerrar(Long id) {

        var sessao = sessaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sessao não encontrada para o ID: " + id));

        sessao.encerrar();

        var sessaoAtualizada = sessaoRepository.save(sessao);

        return sessaoMapper.mapToSessaoResponseDto(sessaoAtualizada);
    }
}
