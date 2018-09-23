package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Professor;
import br.com.same.repository.ProfessorRepository;
import br.com.same.services.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProfessorRepository professorRepository;

	@Override
	public void salvar(Professor professor) {
		professorRepository.save(professor);
	}

	@Override
	public List<Professor> listar() {
		return professorRepository.findAll();
	}

	@Override
	public Professor buscarPorId(Long id) {
		return professorRepository.findBy(id);
	}

	@Override
	public void remover(Professor professor) {
		professorRepository.remove(professor);
	}

	@Override
	public void editar(Professor professor) {
		professorRepository.save(professor);
	}

	@Override
	public EntityRepository<Professor, Long> getRepository() {
		return this.professorRepository;
	}

}
