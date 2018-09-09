package br.com.same.models;

public class Disciplina extends EntidadeBase {

	public Disciplina() {
	}

	public Disciplina(String nome) {
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
