package br.com.db.desafio.votacao.usecase.associado.impl;

import br.com.db.desafio.votacao.controller.associado.dto.AssociadoRequestDto;
import br.com.db.desafio.votacao.controller.associado.dto.AssociadoResponseDto;
import br.com.db.desafio.votacao.repository.AssociadoRepository;
import br.com.db.desafio.votacao.usecase.associado.AssociadoMapper;
import br.com.db.desafio.votacao.usecase.associado.CadastroAssociadoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroAssociadoUseCaseImpl implements CadastroAssociadoUseCase {

    private final AssociadoMapper associadoMapper;
    private final AssociadoRepository associadoRepository;

    @Override
    public AssociadoResponseDto cadastrar(AssociadoRequestDto associadoRequestDto) {

        var associado = associadoMapper.mapToAssociado(associadoRequestDto);

        var associadoSalvo = associadoRepository.save(associado);

        return associadoMapper.mapToAssociadoResponseDto(associadoSalvo);
    }
}
