package br.com.same.services;

import java.io.Serializable;
import java.util.List;

import br.com.same.models.Professor;

public interface ProfessorService extends Serializable {

	void salvar(Professor professor);

	void editar(Professor professor);

	List<Professor> listar();

	Professor buscarPorId(Long id);

	void remover(Professor professor);

}
