package br.com.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "aluno")
@Table(name = "aluno")
public class Aluno extends EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3947134927811336946L;

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
