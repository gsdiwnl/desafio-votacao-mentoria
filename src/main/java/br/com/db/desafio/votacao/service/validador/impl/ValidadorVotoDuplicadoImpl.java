package br.com.db.desafio.votacao.service.validador.impl;

import br.com.db.desafio.votacao.exception.InvalidVoteException;
import br.com.db.desafio.votacao.repository.VotoRepository;
import br.com.db.desafio.votacao.service.validador.DadosValidacao;
import br.com.db.desafio.votacao.service.validador.Validador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidadorVotoDuplicadoImpl implements Validador {

    private final VotoRepository votoRepository;

    @Override
    public void validar(DadosValidacao dadosValidacao) {

        var votos = votoRepository.findByPautaId(dadosValidacao.getIdPauta());

        if (votos.stream().anyMatch(v -> v.getCpfAssociado().equals(dadosValidacao.getCpfAssociado()))) {

            throw new InvalidVoteException("Associado já votou nessa pauta!");
        }
    }
}
