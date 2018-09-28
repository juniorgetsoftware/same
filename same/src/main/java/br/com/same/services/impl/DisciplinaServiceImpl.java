package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Disciplina;
import br.com.same.repository.DisciplinaRepository;
import br.com.same.services.DisciplinaService;

public class DisciplinaServiceImpl implements DisciplinaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private DisciplinaRepository disciplinaRepository;

	@Override
	public void salvar(Disciplina disciplina) {
		disciplinaRepository.save(disciplina);
	}

	@Override
	public List<Disciplina> listar() {
		return disciplinaRepository.findAll();
	}

	@Override
	public Disciplina buscarPorId(Long id) {
		return disciplinaRepository.findBy(id);
	}

	@Override
	public void remover(Disciplina disciplina) {
		disciplinaRepository.remove(disciplina);
	}

	@Override
	public void editar(Disciplina disciplina) {
		disciplinaRepository.save(disciplina);
	}

	@Override
	public EntityRepository<Disciplina, Long> getRepository() {
		return disciplinaRepository;
	}

}
