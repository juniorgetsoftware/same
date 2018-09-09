package br.com.same.services.impl;

import javax.inject.Inject;

import br.com.same.daos.UsuarioDAO;
import br.com.same.models.Usuario;
import br.com.same.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private UsuarioDAO dao;
	
	@Override
	public Usuario usuarioPorEmail(String email) {
		return dao.buscarPorAtributo("select u from usuario u where u.email = :email", "email", email);
	}

}
