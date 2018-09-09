package br.com.same.models;

public enum Turno {

	MATUTINO("Matutino"), 
	VESPERTINO("Matutino"), 
	NOTURNO("Matutino");
	
	Turno(String descricao) {
		this.descricao = descricao;
	}
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
}
