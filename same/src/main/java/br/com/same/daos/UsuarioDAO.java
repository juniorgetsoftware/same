package br.com.same.daos;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.same.models.Usuario;

public class UsuarioDAO extends GenericDao<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2295289947404745373L;

	@Inject
	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
