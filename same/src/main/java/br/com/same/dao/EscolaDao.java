package br.com.same.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import br.com.same.models.Escola;

public class EscolaDao {
	
	@Inject
	private EntityManager entityManager;
	
	@Transactional
	public void salvar(Escola escola) {
		entityManager.merge(escola);
	}

}
