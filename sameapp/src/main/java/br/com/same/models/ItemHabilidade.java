package br.com.same.models;

public class ItemHabilidade {

	public ItemHabilidade() {
	}

	public ItemHabilidade(String nome) {
		this();
		this.nome = nome;
	}

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
