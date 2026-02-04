package br.com.db.desafio.votacao.repository;

import br.com.db.desafio.votacao.model.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {
    Associado findByCpf(String cpf);
}
