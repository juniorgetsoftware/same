package br.com.same.models;

public enum NivelDificuldadeQuestao {
	
	MUITO_FACIL("Muito fácil"), 
	FACIL("fácil"), 
	INTERMIDIARIO("Intermediário"),
	DIFICIL("difícil"),
	MUIRO_DIFICIL("Muito difícil");
	
	NivelDificuldadeQuestao(String descricao) {
		this.descricao = descricao;
	}
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}

}
