package br.com.models;

public enum TipoQuestao {

	OBJETIVA("Objetiva"),
	SUBJETIVA("Subjetiva"),
	VERDADEIRO_FALSO("Verdadeiro ou Falso");

	private TipoQuestao(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

}
