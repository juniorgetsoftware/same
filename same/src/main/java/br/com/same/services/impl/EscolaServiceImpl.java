package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import br.com.same.dao.EscolaDao;
import br.com.same.models.Escola;
import br.com.same.services.EscolaService;

public class EscolaServiceImpl implements EscolaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EscolaDao escolaDao;

	@Override
	public void salvar(Escola escola) {
		escolaDao.salvar(escola);
	}

	@Override
	public List<Escola> listar() {
		return escolaDao.listar();
	}

	@Override
	public Escola buscarPorId(Long id) {
		return escolaDao.buscarPorId(id);
	}

	@Override
	public void remover(Escola escola) {
		escolaDao.remover(escola);
	}

	@Override
	public void editar(Escola escola) {
		escolaDao.editar(escola);
	}

}
