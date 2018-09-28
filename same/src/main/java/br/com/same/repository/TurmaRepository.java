package br.com.same.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Turma;

@Repository
@ApplicationScoped
public interface TurmaRepository extends EntityRepository<Turma, Long> {

}
