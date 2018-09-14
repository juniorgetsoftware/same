package br.com.same.services.impl;

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

}
