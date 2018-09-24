package br.com.same.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Aluno;

@Repository
@ApplicationScoped
public interface AlunoRepository extends EntityRepository<Aluno, Long> {

}
