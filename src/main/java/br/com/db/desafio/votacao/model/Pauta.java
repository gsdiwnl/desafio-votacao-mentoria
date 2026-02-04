package br.com.db.desafio.votacao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;

    // Violação SRP: Pauta não deveria ter lógica de sessão
    private LocalDateTime sessaoInicio;
    private LocalDateTime sessaoFim;
    private Boolean sessaoAberta;

    // Violação SRP: Pauta gerenciando votos diretamente
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Voto> votos = new ArrayList<>();

    // Violação SRP: Lógica de negócio na entidade
    public String calcularResultado() {
        int sim = 0;
        int nao = 0;

        for (Voto v : votos) {
            if (v.getVoto().equals("SIM")) {
                sim++;
            } else if (v.getVoto().equals("NAO")) {
                nao++;
            }
        }

        return "Total de votos: " + (sim + nao) + " | SIM: " + sim + " | NAO: " + nao +
               " | Resultado: " + (sim > nao ? "APROVADO" : sim < nao ? "REJEITADO" : "EMPATE");
    }

    // Violação SRP: Validação de CPF na entidade de Pauta
    public boolean validarCPF(String cpf) {
        // Fake validation
        return cpf != null && cpf.length() == 11;
    }
}
