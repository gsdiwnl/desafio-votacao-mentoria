package br.com.db.desafio.votacao.service.validador;

import br.com.db.desafio.votacao.service.validador.impl.ValidadorAssociadoImpl;
import br.com.db.desafio.votacao.service.validador.impl.ValidadorSessaoImpl;
import br.com.db.desafio.votacao.service.validador.impl.ValidadorVotoDuplicadoImpl;
import br.com.db.desafio.votacao.service.validador.impl.ValidadorVotoValidoImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum EtapasValidacao {

    VOTACAO(List.of(
            ValidadorVotoValidoImpl.class,
            ValidadorVotoDuplicadoImpl.class,
            ValidadorSessaoImpl.class,
            ValidadorAssociadoImpl.class
    ));

    private final Collection<Class<? extends Validador>> validadores;
}
