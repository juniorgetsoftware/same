package br.com.models;

public enum StatusEntidade {

	ATIVO("Ativo"), INATIVO("Inativo");

	private StatusEntidade(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}
}
