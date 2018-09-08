package br.com.same.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prova extends EntidadeBase {

	public Prova() {
		this.questoes = new ArrayList<>();
	}

	public Prova(String nome) {
		this();
		this.nome = nome;
	}

	private String nome;
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
