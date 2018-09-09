package br.com.same.builder;

import java.util.Arrays;

import br.com.same.models.Pagina;
import br.com.same.models.Perfil;
import br.com.same.models.StatusEntidade;

public class PerfilBuilder {

	private Perfil perfil;

	public PerfilBuilder() {
		this.perfil = new Perfil();
	}

	public PerfilBuilder comDescricao(String descricao) {
		this.perfil.setDescricao(descricao);
		return this;
	}

	public PerfilBuilder comNome(String nome) {
		this.perfil.setNome(nome);
		return this;
	}

	public PerfilBuilder comPaginas(Pagina... paginas) {
		this.perfil.setPaginas(Arrays.asList(paginas));
		return this;
	}

	public PerfilBuilder comStatus(StatusEntidade status) {
		this.perfil.setStatus(status);
		return this;
	}

	public PerfilBuilder ativo() {
		this.perfil.setStatus(StatusEntidade.ATIVO);
		return this;
	}

	public PerfilBuilder inativo() {
		this.perfil.setStatus(StatusEntidade.INATIVO);
		return this;
	}

	public Perfil builder() {
		return this.perfil;
	}
}
