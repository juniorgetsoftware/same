package br.com.same.services;

import java.io.Serializable;
import java.util.List;

import br.com.same.models.Disciplina;

public interface DisciplinaService extends Serializable {

	void salvar(Disciplina disciplina);

	void editar(Disciplina disciplina);

	List<Disciplina> listar();

	Disciplina buscarPorId(Long id);

	void remover(Disciplina disciplina);

}
