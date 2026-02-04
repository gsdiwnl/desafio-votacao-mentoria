package br.com.db.desafio.votacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String nome;
    private String status; // ABLE_TO_VOTE ou UNABLE_TO_VOTE

    // Violação SRP: Lógica de validação na entidade
    public boolean podeVotar() {
        // Fake random validation
        return Math.random() > 0.5;
    }
}
