package br.com.same.daos;

import static br.com.same.dao.utils.Like.startswith;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.same.models.EntidadeBase;

@SuppressWarnings("unchecked")
public abstract class GenericDao<T extends EntidadeBase> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5031297764289032113L;

	@PersistenceContext
	private EntityManager em;

	private Class<T> clazz;

	public GenericDao(EntityManager entityManager) {
		this();
		this.em = entityManager;
	}

	public GenericDao() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void cadastrar(T t) {
		em.merge(t);
	}
	
	public T buscarPorAtributo(String jpql, String campo, Object valor) {
		return (T) em.createQuery(jpql)
		.setParameter(campo, startswith(valor))
		.getSingleResult();
	}

	public T buscarPorAtributos(String jpql, Object...parametros ) {
		Query createQuery = em.createQuery(jpql);
		for (int i = 0; i < parametros.length; i++) {
			createQuery.setParameter(parametros[i].toString(), parametros[i+1]);
		}
	return (T) createQuery.getSingleResult();
	}

	public void editar(T t) {
		em.merge(t);
	}

	public void remover(T t) {
		t = buscarPorId(t.getId());
		if (t != null) {
			em.remove(t);
		}
	}

	public T buscarPorId(Long id) {
		return em.find(clazz, id);
	}

	public List<T> listar() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> createQuery = criteriaBuilder.createQuery(clazz);
		return em.createQuery(createQuery).getResultList();
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public List<T> listarComNamedQuery(String jpql) {
		return em.createQuery(jpql, clazz).getResultList();
	}
}
