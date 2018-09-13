package br.com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "prova")
@Table(name = "prova")
public class Prova extends EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Prova() {
		this.questoes = new ArrayList<>();
	}

	public Prova(String nome) {
		this();
		this.nome = nome;
	}

	private String nome;
	
	@Transient
	private List<Questao> questoes;

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionar(Questao questao) {
		this.questoes.add(questao);
	}

	public void adicionar(Questao... questoes) {
		this.questoes.addAll(Arrays.asList(questoes));
	}
}
