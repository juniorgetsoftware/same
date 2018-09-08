package br.com.same.services.impl;

import javax.inject.Inject;

import br.com.same.dao.EscolaDao;
import br.com.same.models.Escola;
import br.com.same.services.EscolaService;

public class EscolaServiceImpl implements EscolaService {

	private static final long serialVersionUID = 5065060801865710320L;

	@Inject
	private EscolaDao escolaDao;

	@Override
	public void cadastrar(Escola escola) {
		validar(escola);
		escolaDao.cadastrar(escola);
	}

	private void validar(Escola escola) {

	}

}
