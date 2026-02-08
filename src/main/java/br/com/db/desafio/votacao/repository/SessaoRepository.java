package br.com.db.desafio.votacao.repository;

import br.com.db.desafio.votacao.model.sessao.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {
}
