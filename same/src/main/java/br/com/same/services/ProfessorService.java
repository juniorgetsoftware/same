package br.com.same.services;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Professor;

public interface ProfessorService extends Service<Professor, Long> {

	void salvar(Professor professor);

	void editar(Professor professor);

	List<Professor> listar();

	Professor buscarPorId(Long id);

	void remover(Professor professor);

	EntityRepository<Professor, Long> getRepository();

}
