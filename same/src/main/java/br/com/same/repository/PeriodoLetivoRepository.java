package br.com.same.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Escola;
import br.com.same.models.PeriodoLetivo;

@Repository
public interface PeriodoLetivoRepository extends EntityRepository<PeriodoLetivo, Long>{

	List<PeriodoLetivo> findByEscolaOrderByNome(Escola escola);

}
