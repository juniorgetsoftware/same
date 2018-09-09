package br.com.same.models;

public class Aluno extends EntidadeBase {

	public Aluno() {
	}

	public Aluno(String nome) {
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
