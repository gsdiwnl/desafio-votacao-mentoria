package br.com.db.desafio.votacao.service;

import br.com.db.desafio.votacao.model.voto.SituacaoVoto;
import br.com.db.desafio.votacao.model.voto.Voto;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static br.com.db.desafio.votacao.model.voto.SituacaoVoto.NAO;
import static br.com.db.desafio.votacao.model.voto.SituacaoVoto.SIM;

@Service
public class ValidadorVotoService {

    public boolean isVotoValido(SituacaoVoto voto) {

        return (SIM.equals(voto) || NAO.equals(voto));
    }

    public boolean isVotoDuplicado(Collection<Voto> votos, String cpf) {

        return votos.stream().anyMatch(v -> v.getCpfAssociado().equals(cpf));
    }
}
