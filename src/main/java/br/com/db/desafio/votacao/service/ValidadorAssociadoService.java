package br.com.db.desafio.votacao.service;

import br.com.db.desafio.votacao.model.associado.Associado;
import org.springframework.stereotype.Service;

import static br.com.db.desafio.votacao.model.associado.StatusAssociado.ABLE_TO_VOTE;

@Service
public class ValidadorAssociadoService {

    public boolean podeVotar(Associado associado) {

        return ABLE_TO_VOTE.equals(associado.getStatus());
    }
}
