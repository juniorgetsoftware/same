package br.com.same.security;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.same.security.UsuarioLogado;
import br.com.same.security.UsuarioSistema;

@Named
@RequestScoped
public class Seguranca {
	@Inject
	private ExternalContext externalContext;

	public String getNomeUsuario() {
		String nome = null;
		UsuarioSistema usuarioLogado = this.getUsuarioLogado();
		if (usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getNome();
		}

		return nome;
	}

	@Produces
	@UsuarioLogado
	public UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuario = null;
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) FacesContext
				.getCurrentInstance().getExternalContext().getUserPrincipal();
		if (auth != null && auth.getPrincipal() != null) {
			usuario = (UsuarioSistema) auth.getPrincipal();
		}

		return usuario;
	}

	public boolean isEmitirPedidoPermitido() {
		return this.externalContext.isUserInRole("ADMINISTRADORES");
	}

	public boolean isCadastrarPagina() {
		return this.externalContext.isUserInRole("CADASTRAR_PAGINA");
	}

	public boolean isEditarPagina() {
		return this.externalContext.isUserInRole("EDITAR_PAGINA");
	}

	public boolean isListarPagina() {
		return this.externalContext.isUserInRole("LISTAR_PAGINA");
	}

	public boolean isCadastrarUsuario() {
		return this.externalContext.isUserInRole("CADASTRAR_USUARIO");
	}

	public boolean isEditarUsuario() {
		return this.externalContext.isUserInRole("EDITAR_USUARIO");
	}

	public boolean isListarUsuario() {
		return this.externalContext.isUserInRole("LISTAR_USUARIO");
	}

	public boolean isCadastrarPerfil() {
		return this.externalContext.isUserInRole("CADASTRAR_PERFIL");
	}

	public boolean isEditarPerfil() {
		return this.externalContext.isUserInRole("EDITAR_PERFIL");
	}

	public boolean isListarPerfil() {
		return this.externalContext.isUserInRole("LISTAR_PERFIL");
	}

}