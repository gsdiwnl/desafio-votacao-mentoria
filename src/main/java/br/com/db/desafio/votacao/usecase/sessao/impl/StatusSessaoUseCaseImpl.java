package br.com.db.desafio.votacao.usecase.sessao.impl;

import br.com.db.desafio.votacao.controller.sessao.SessaoMapper;
import br.com.db.desafio.votacao.controller.sessao.SessaoResponseDto;
import br.com.db.desafio.votacao.controller.sessao.StatusSessaoResponseDto;
import br.com.db.desafio.votacao.exception.ResourceNotFoundException;
import br.com.db.desafio.votacao.model.sessao.Sessao;
import br.com.db.desafio.votacao.repository.SessaoRepository;
import br.com.db.desafio.votacao.usecase.sessao.StatusSessaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusSessaoUseCaseImpl implements StatusSessaoUseCase {

    private final SessaoRepository sessaoRepository;
    private final SessaoMapper sessaoMapper;

    @Override
    public StatusSessaoResponseDto consultar(Long id) {

        var sessao = buscarPorId(id);

        return sessaoMapper.mapToStatusSessaoResponseDto(sessao.getStatus());
    }

    @Override
    public SessaoResponseDto encerrar(Long id) {

        var sessao = buscarPorId(id);
        sessao.encerrar();

        var sessaoAtualizada = sessaoRepository.save(sessao);

        return sessaoMapper.mapToSessaoResponseDto(sessaoAtualizada);
    }

    private Sessao buscarPorId(Long id) {

        return sessaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sessao não encontrada para o ID: " + id));
    }
}
