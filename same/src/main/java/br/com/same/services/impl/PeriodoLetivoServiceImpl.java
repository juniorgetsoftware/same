package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import br.com.same.dao.PeriodoLetivoDao;
import br.com.same.models.PeriodoLetivo;
import br.com.same.services.PeriodoLetivoService;

public class PeriodoLetivoServiceImpl implements PeriodoLetivoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PeriodoLetivoDao periodoLetivoDao;

	@Override
	public void salvar(PeriodoLetivo periodoLetivo) {
		periodoLetivoDao.salvar(periodoLetivo);
	}

	@Override
	public List<PeriodoLetivo> listar() {
		return periodoLetivoDao.listar();
	}

	@Override
	public PeriodoLetivo buscarPorId(Long id) {
		return periodoLetivoDao.buscarPorId(id);
	}

	@Override
	public void remover(PeriodoLetivo periodoLetivo) {
		periodoLetivoDao.remover(periodoLetivo);
	}

	@Override
	public void editar(PeriodoLetivo periodoLetivo) {
		periodoLetivoDao.editar(periodoLetivo);
	}

}
