package br.com.same.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Disciplina;

@Repository
public interface DisciplinaRepository extends EntityRepository<Disciplina, Long> {

}
