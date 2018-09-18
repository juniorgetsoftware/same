package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import br.com.same.dao.EscolaDao;
import br.com.same.models.Escola;
import br.com.same.services.EscolaService;

public class EscolaServiceImpl implements EscolaService {

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

}
