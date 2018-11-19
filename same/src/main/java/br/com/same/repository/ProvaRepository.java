package br.com.same.repository;

import java.io.Serializable;
import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Prova;
import br.com.same.models.Turma;

@Repository
public interface ProvaRepository extends EntityRepository<Prova, Long>, Serializable {

//	@Query("select distinct p from prova p "
//			+ "join p.gabarito g "
//			+ "join g.alternativas "
//			+ "join p.questoes q "
//			+ "join q.alternativas a "
//			+ "where p.turma = ?1")
	List<Prova> findByTurma(Turma turma);
	
}
