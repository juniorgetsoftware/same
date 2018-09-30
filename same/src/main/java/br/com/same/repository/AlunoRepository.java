package br.com.same.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Aluno;
import br.com.same.models.Turma;

@Repository
@ApplicationScoped
public interface AlunoRepository extends EntityRepository<Aluno, Long> {

	List<Aluno> findByTurmaOrderByNome(Turma turma);

}
