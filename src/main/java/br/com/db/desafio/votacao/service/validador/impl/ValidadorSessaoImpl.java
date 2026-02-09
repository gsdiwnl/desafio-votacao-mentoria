package br.com.db.desafio.votacao.service.validador.impl;

import br.com.db.desafio.votacao.exception.InvalidVoteException;
import br.com.db.desafio.votacao.model.sessao.Status;
import br.com.db.desafio.votacao.service.validador.DadosValidacao;
import br.com.db.desafio.votacao.service.validador.Validador;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorSessaoImpl implements Validador {

    @Override
    public void validar(DadosValidacao dadosValidacao) {

        var sessao = dadosValidacao.getSessao();

        if (LocalDateTime.now().isAfter(sessao.getFim()) ||
                Status.ENCERRADA.equals(sessao.getStatus())) {

            throw new InvalidVoteException("Sessão de votação não está aberta!");
        }
    }
}
