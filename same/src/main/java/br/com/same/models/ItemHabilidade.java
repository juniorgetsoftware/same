package br.com.same.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "item_habilidade")
@Table(name = "item_habilidade")
public class ItemHabilidade extends EntidadeBase implements Serializable {

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
