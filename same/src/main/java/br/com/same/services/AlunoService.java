package br.com.same.services;

import java.util.List;

import br.com.same.models.Aluno;
import br.com.same.models.Turma;

public interface AlunoService extends Service<Aluno, Long> {

	List<Aluno> listar(Turma turma);

}
