package br.com.same.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.same.daos.UsuarioDAO;
import br.com.same.infra.cdi.CDIServiceLocator;
import br.com.same.models.Pagina;
import br.com.same.models.Usuario;

public class AppUserDetailsService implements UserDetailsService {

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuarioDAO usuarioDao = CDIServiceLocator.getBean(UsuarioDAO.class);
		Usuario usuario = usuarioDao.usuarioPorEmail(email);
		UsuarioSistema user = null;
		if (usuario != null) {
			user = new UsuarioSistema(usuario, this.getPaginas(usuario));
			return user;
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado.");
		}
	}

	private Collection<? extends GrantedAuthority> getPaginas(Usuario usuario) {
		ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Pagina grupo : usuario.getPaginas()) {
			String group = "ROLE_" + grupo.getNomeIdentificador();
			authorities.add(new SimpleGrantedAuthority(group));
		}
		return authorities;
	}
}