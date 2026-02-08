package br.com.db.desafio.votacao.repository;

import br.com.db.desafio.votacao.model.voto.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

    Collection<Voto> findByPautaId(Long pautaId);
}
