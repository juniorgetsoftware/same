package br.com.same.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Escola;

@Repository
@ApplicationScoped
public interface EscolaRepository extends EntityRepository<Escola, Long> {
	
	List<Escola> findByNomeLike(String nome);

}
