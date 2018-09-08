package br.com.same.models;

import java.util.List;
import java.util.stream.Collectors;

public class Gabarito extends EntidadeBase {

	public Gabarito(Prova prova) {
		this.prova = prova;
	}
	
	private Prova prova;
	
	public List<Resposta> gabarito() {
		return prova.getQuestoes().stream()
				.map(Questao::getRespostas)
				.flatMap(List::stream)
				.filter(r -> r.isRespostaCorreta())
				.collect(Collectors.toList());
	}
}
