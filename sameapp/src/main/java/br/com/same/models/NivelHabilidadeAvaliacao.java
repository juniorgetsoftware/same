package br.com.same.models;

public enum NivelHabilidadeAvaliacao {
	
	MUITO_CRITICO("Muito crítico"), 
	CRITICO("Crítico"), 
	SATISFATORIO("Satisfatório"),
	BOM("Bom"),
	EXCELENTE("Excelente");
	
	NivelHabilidadeAvaliacao(String descricao) {
		this.descricao = descricao;
	}
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}

}
