package br.com.db.desafio.votacao.model.sessao;

import br.com.db.desafio.votacao.exception.InvalidStatusException;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime inicio;
    private LocalDateTime fim;

    @Enumerated(EnumType.STRING)
    private Status status;

    public void encerrar() {

        if (this.status != Status.ABERTA) {

            throw new InvalidStatusException("A sessão não pode ser encerrada porque não está aberta.");
        }

        this.status = Status.ENCERRADA;
        this.fim = LocalDateTime.now();
    }
}
