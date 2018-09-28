package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Turma;
import br.com.same.repository.TurmaRepository;
import br.com.same.services.TurmaService;

public class TurmaServiceImpl implements TurmaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private TurmaRepository turmaRepository;

	@Override
	public void salvar(Turma turma) {
		turmaRepository.save(turma);
	}

	@Override
	public List<Turma> listar() {
		return turmaRepository.findAll();
	}

	@Override
	public Turma buscarPorId(Long id) {
		return turmaRepository.findBy(id);
	}

	@Override
	public void remover(Turma turma) {
		turmaRepository.remove(turma);
	}

	@Override
	public void editar(Turma turma) {
		turmaRepository.save(turma);
	}

	@Override
	public EntityRepository<Turma, Long> getRepository() {
		return turmaRepository;
	}

}
