package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import br.com.same.dao.TurmaDao;
import br.com.same.models.Turma;
import br.com.same.services.TurmaService;

public class TurmaServiceImpl implements TurmaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TurmaDao turmaDao;

	@Override
	public void salvar(Turma turma) {
		turmaDao.salvar(turma);
	}

	@Override
	public List<Turma> listar() {
		return turmaDao.listar();
	}

	@Override
	public Turma buscarPorId(Long id) {
		return turmaDao.buscarPorId(id);
	}

	@Override
	public void remover(Turma turma) {
		turmaDao.remover(turma);
	}

	@Override
	public void editar(Turma turma) {
		turmaDao.editar(turma);
	}

}
