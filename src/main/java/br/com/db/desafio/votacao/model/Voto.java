package br.com.db.desafio.votacao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpfAssociado;
    private String voto; // SIM ou NAO
    private LocalDateTime dataHora;

    @ManyToOne
    private Pauta pauta;

    // Violação SRP: Lógica de validação na entidade
    public boolean isVotoValido() {
        return voto != null && (voto.equals("SIM") || voto.equals("NAO"));
    }
}
