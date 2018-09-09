package br.com.same.models;

public class Professor extends EntidadeBase {

	public Professor() {
	}

	public Professor(String nome) {
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
