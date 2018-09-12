package br.com.same.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "professor")
@Table(name = "professor")
public class Professor extends EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3836899332152683975L;

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
