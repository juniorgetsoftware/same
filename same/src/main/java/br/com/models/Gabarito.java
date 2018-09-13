package br.com.models;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "gabarito")
@Table(name = "gabarito")
public class Gabarito extends EntidadeBase implements Serializable {

	public Gabarito() {
	}

	public Gabarito(Prova prova) {
		this.prova = prova;
	}

	@OneToOne
	private Prova prova;

	@Transient
	public List<Resposta> gabarito() {
		return prova.getQuestoes().stream().map(Questao::getRespostas).flatMap(List::stream)
				.filter(r -> r.isRespostaCorreta()).collect(Collectors.toList());
	}
}
