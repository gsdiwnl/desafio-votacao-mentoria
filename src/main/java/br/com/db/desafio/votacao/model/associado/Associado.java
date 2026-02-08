package br.com.db.desafio.votacao.model.associado;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String nome;

    @Enumerated(EnumType.STRING)
    private StatusAssociado status;
}
