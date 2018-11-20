package br.com.same.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "habilidade")
@Table(name = "habilidade")
public class Habilidade extends EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
