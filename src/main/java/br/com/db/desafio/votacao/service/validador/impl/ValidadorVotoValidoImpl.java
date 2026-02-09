package br.com.db.desafio.votacao.service.validador.impl;

import br.com.db.desafio.votacao.exception.InvalidVoteException;
import br.com.db.desafio.votacao.model.voto.SituacaoVoto;
import br.com.db.desafio.votacao.service.validador.DadosValidacao;
import br.com.db.desafio.votacao.service.validador.Validador;
import org.springframework.stereotype.Component;

@Component
public class ValidadorVotoValidoImpl implements Validador {

    @Override
    public void validar(DadosValidacao dadosValidacao) {

        if (SituacaoVoto.SIM.equals(dadosValidacao.getSituacaoVoto())
                || SituacaoVoto.NAO.equals(dadosValidacao.getSituacaoVoto())) {

            throw new InvalidVoteException("Voto deve ser SIM ou NAO!");
        }
    }
}
