package br.com.db.desafio.votacao.service;

import br.com.db.desafio.votacao.exception.InvalidDurationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessaoService {

    public LocalDateTime calcularFim(Integer duracao) {

        if (duracao == null || duracao <= 0) {
            return LocalDateTime.now().plusMinutes(1);
        } else if (duracao <= 1440) {
            return LocalDateTime.now().plusMinutes(duracao);
        } else {
            throw new InvalidDurationException("ERRO: Duração inválida! Máximo 1440 minutos (24h)");
        }
    }
}
