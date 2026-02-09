package br.com.db.desafio.votacao.service.validador.impl;

import br.com.db.desafio.votacao.exception.InvalidVoteException;
import br.com.db.desafio.votacao.repository.AssociadoRepository;
import br.com.db.desafio.votacao.service.validador.DadosValidacao;
import br.com.db.desafio.votacao.service.validador.Validador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.db.desafio.votacao.model.associado.StatusAssociado.UNABLE_TO_VOTE;

@Component
@RequiredArgsConstructor
public class ValidadorAssociadoImpl implements Validador {

    private final AssociadoRepository associadoRepository;

    @Override
    public void validar(DadosValidacao dadosValidacao) {

        var associado = associadoRepository.findByCpf(dadosValidacao.getCpfAssociado());

        if (associado == null || UNABLE_TO_VOTE.equals(associado.getStatus())) {

            throw new InvalidVoteException("Associado não pode votar!");
        }
    }
}
