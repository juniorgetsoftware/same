package br.com.same.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import br.com.same.models.PeriodoLetivo;

public class PeriodoLetivoDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;

	@Transactional
	public void salvar(PeriodoLetivo periodoLetivo) {
		entityManager.persist(periodoLetivo);
	}

	@Transactional
	public void editar(PeriodoLetivo periodoLetivo) {
		entityManager.merge(periodoLetivo);
	}

	public List<PeriodoLetivo> listar() {
		return entityManager.createQuery("from periodoLetivo", PeriodoLetivo.class).getResultList();
	}

	public PeriodoLetivo buscarPorId(Long id) {
		return entityManager.find(PeriodoLetivo.class, id);
	}

	@Transactional
	public void remover(PeriodoLetivo periodoLetivo) {
		periodoLetivo = buscarPorId(periodoLetivo.getId());
		entityManager.remove(periodoLetivo);
	}

}
