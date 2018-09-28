package br.com.same.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.PeriodoLetivo;

@ApplicationScoped
@Repository(forEntity = PeriodoLetivo.class)
public interface PeriodoLetivoRepository extends EntityRepository<PeriodoLetivo, Long>{

}
