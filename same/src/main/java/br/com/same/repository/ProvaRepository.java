package br.com.same.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Prova;
import br.com.same.models.Turma;

@Repository
public interface ProvaRepository extends EntityRepository<Prova, Long> {

	List<Prova> findByTurma(Turma turma);
	
}
