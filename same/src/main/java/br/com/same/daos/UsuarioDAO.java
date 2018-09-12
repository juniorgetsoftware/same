package br.com.same.daos;

import static br.com.same.dao.utils.Like.startswith;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.same.models.Usuario;

public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public UsuarioDAO() {

	}

	public UsuarioDAO(EntityManager manager) {
		super();
		this.manager = manager;
	}

	public void save(Usuario product) {
		manager.persist(product);
	}
	
	public List<Usuario> olderUsuarios() {
		return manager.createQuery("select b from Usuario b", Usuario.class).setMaxResults(20).getResultList();
	}

	public Usuario findById(Integer id) {
		return manager.find(Usuario.class, id);
	}
	
//	@Inject
//	public UsuarioDAO(EntityManager entityManager) {
//		super(entityManager);
//	}

	@PersistenceContext()
	private EntityManager em;
	
	public Usuario usuarioPorEmail(String email) {
		String jpql = "select u from usuario u where u.email = :email";
//		return buscarPorAtributo("select u from usuario u where u.email = :email", "email", email);
		return (Usuario) em.createQuery(jpql).setParameter("email", startswith(email)).getSingleResult();
	}

}
