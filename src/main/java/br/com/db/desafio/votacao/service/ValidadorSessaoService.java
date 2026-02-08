package br.com.db.desafio.votacao.service;

import br.com.db.desafio.votacao.model.sessao.Sessao;
import br.com.db.desafio.votacao.model.sessao.Status;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ValidadorSessaoService {

    public boolean isSessaoEncerrada(Sessao sessao) {

        return LocalDateTime.now().isAfter(sessao.getFim()) ||
                Status.ENCERRADA.equals(sessao.getStatus());
    }
}
