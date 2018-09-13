package br.com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "habilidade")
@Table(name = "habilidade")
public class Habilidade extends EntidadeBase implements Serializable {

	public Habilidade() {
		itens = new ArrayList<>();
	}

	public Habilidade(String nome) {
		this();
		this.nome = nome;
	}

	private String nome;
	
	@OneToMany
	private List<ItemHabilidade> itens;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ItemHabilidade> getItens() {
		return itens;
	}

	public void setItens(List<ItemHabilidade> itens) {
		this.itens = itens;
	}

	public void adicionar(ItemHabilidade... itens) {
		this.itens.addAll(Arrays.asList(itens));
	}

	public void adicionar(ItemHabilidade item) {
		this.itens.add(item);
	}

	public void remover(ItemHabilidade item) {
		this.itens.remove(item);
	}

}
