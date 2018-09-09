package br.com.same.builder;

import java.util.Arrays;

import br.com.same.models.Pagina;
import br.com.same.models.Perfil;
import br.com.same.models.StatusEntidade;
import br.com.same.models.Usuario;

public class UsuarioBuilder {

	private Usuario usuario;

	public UsuarioBuilder() {
		this.usuario = new Usuario();
	}

	public UsuarioBuilder comEmail(String email) {
		this.usuario.setEmail(email);
		return this;
	}

	public UsuarioBuilder comNome(String nome) {
		this.usuario.setNome(nome);
		return this;
	}

	public UsuarioBuilder comPaginas(Pagina... paginas) {
		this.usuario.setPaginas(Arrays.asList(paginas));
		return this;
	}

	public UsuarioBuilder comPerfil(Perfil perfil) {
		this.usuario.setPerfil(perfil);
		return this;
	}

	public UsuarioBuilder comSenha(String senha) {
		this.usuario.setSenha(senha);
		return this;
	}

	public UsuarioBuilder comStatus(StatusEntidade status) {
		this.usuario.setStatus(status);
		return this;
	}

	public UsuarioBuilder ativo() {
		this.usuario.setStatus(StatusEntidade.ATIVO);
		return this;
	}

	public UsuarioBuilder inativo() {
		this.usuario.setStatus(StatusEntidade.INATIVO);
		return this;
	}

	public Usuario build() {
		return this.usuario;
	}

	public UsuarioBuilder comId(Long id) {
		this.usuario.setId(id);
		return this;
	}
}
