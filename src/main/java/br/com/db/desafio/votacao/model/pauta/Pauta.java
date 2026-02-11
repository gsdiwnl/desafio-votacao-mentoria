package br.com.db.desafio.votacao.model.pauta;

import br.com.db.desafio.votacao.model.sessao.Sessao;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sessao_id", referencedColumnName = "id")
    private Sessao sessao;
}
