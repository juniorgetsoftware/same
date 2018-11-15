package br.com.same.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Escola;

@Repository
public interface EscolaRepository extends EntityRepository<Escola, Long> {
	
	List<Escola> findByNomeLike(String nome);

}
