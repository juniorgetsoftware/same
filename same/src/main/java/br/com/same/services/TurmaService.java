package br.com.same.services;

import java.io.Serializable;
import java.util.List;

import br.com.same.models.Turma;

public interface TurmaService extends Serializable {

	void salvar(Turma turma);

	void editar(Turma turma);

	List<Turma> listar();

	Turma buscarPorId(Long long1);

	void remover(Turma turma);

}
