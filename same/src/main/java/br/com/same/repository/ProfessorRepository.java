package br.com.same.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Professor;

@Repository
public interface ProfessorRepository extends EntityRepository<Professor, Long> {

}
