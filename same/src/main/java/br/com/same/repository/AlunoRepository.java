package br.com.same.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Aluno;
import br.com.same.models.Turma;

@Repository
public interface AlunoRepository extends EntityRepository<Aluno, Long> {

	@Query(value = "select a from turma t join t.alunos a where t = ?1 order by a.nome")
	List<Aluno> findByTurmaOrderByNome(Turma turma);
	
}
