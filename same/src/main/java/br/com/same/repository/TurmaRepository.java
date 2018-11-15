package br.com.same.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.PeriodoLetivo;
import br.com.same.models.Turma;

@Repository
public interface TurmaRepository extends EntityRepository<Turma, Long> {

	List<Turma> findByPeriodoLetivoOrderByNome(PeriodoLetivo periodo);

}
