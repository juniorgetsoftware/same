package br.com.service.impl;

import javax.inject.Inject;

import br.com.dao.EscolaDao;
import br.com.models.Escola;
import br.com.service.EscolaService;
import br.com.service.Impl;

@Impl
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

}
