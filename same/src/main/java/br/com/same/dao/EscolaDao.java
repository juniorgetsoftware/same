package br.com.same.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import br.com.same.models.Escola;

public class EscolaDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;

	@Transactional
	public void salvar(Escola escola) {
		entityManager.persist(escola);
	}

//	@Transactional
	public void editar(Escola escola) {
		entityManager.merge(escola);
	}

	public List<Escola> listar() {
		return entityManager.createQuery("from escola", Escola.class).getResultList();
	}

	public Escola buscarPorId(Long id) {
		return entityManager.find(Escola.class, id);
	}

	@Transactional
	public void remover(Escola escola) {
		escola = buscarPorId(escola.getId());
		entityManager.remove(escola);
	}

}
