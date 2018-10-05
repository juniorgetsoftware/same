package br.com.same.models;

public enum Status {
	
	ATIVO ("Ativo", "fa-check", "color:#30ab2e"),
	INATIVO ("Inativo", "fa-ban", "color:#f77049");
	
	Status(String descricao, String icone, String cor){
		this.descricao = descricao;
		this.icone = icone;
		this.cor = cor;
	}
	
	String descricao;
	String icone;
	String cor;
	
	public String getDescricao() {
		return descricao;
	}
	public String getIcone() {
		return icone;
	}
	public String getCor() {
		return cor;
	}
	
}
