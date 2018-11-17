package br.com.same.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.AlunoProva;
import br.com.same.models.Prova;

@Repository
public interface AlunoProvaRepository extends EntityRepository<AlunoProva, Long>{

	List<AlunoProva> findByProva(Prova prova);

}
