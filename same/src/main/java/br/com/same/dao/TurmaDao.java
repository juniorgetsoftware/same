package br.com.same.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import br.com.same.models.Turma;

public class TurmaDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;

	@Transactional
	public void salvar(Turma turma) {
		entityManager.persist(turma);
	}

	@Transactional
	public void editar(Turma turma) {
		entityManager.merge(turma);
	}

	public List<Turma> listar() {
		return entityManager.createQuery("from turma", Turma.class).getResultList();
	}

	public Turma buscarPorId(Long id) {
		return entityManager.find(Turma.class, id);
	}

	@Transactional
	public void remover(Turma turma) {
		turma = buscarPorId(turma.getId());
		entityManager.remove(turma);
	}

}
