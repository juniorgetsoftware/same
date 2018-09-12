package br.com.same.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "disciplina")
@Table(name = "disciplina")
public class Disciplina extends EntidadeBase implements Serializable{

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
