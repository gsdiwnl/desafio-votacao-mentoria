package br.com.db.desafio.votacao.model.voto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pautaId;

    private String cpfAssociado;

    @Enumerated(EnumType.STRING)
    private SituacaoVoto situacao;
    private LocalDateTime dataHora;

}
