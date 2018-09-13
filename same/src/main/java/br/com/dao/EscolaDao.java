package br.com.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.models.Escola;

public class EscolaDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;

	public Escola salvar(Escola escola) {
		return manager.merge(escola);
	}

}
