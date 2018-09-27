package br.com.same.controllers;

import static java.util.Objects.isNull;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.same.models.Prova;

@Named
@ViewScoped
public class ProvaCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Prova prova;
	private int quantidadeQuestoes;
	private int quantidadeAlternativasPorQuestao;

	public void gerarCamposProva() {
		this.getProva().gerarCamposDaProva(quantidadeQuestoes, quantidadeAlternativasPorQuestao);
	}
	
	public void cadastrar () {
		System.out.println(prova);
	}
	//
	
	public Prova getProva() {
		if(isNull(prova)) prova = new Prova();
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public int getQuantidadeQuestoes() {
		return quantidadeQuestoes;
	}

	public void setQuantidadeQuestoes(int quantidadeQuestoes) {
		this.quantidadeQuestoes = quantidadeQuestoes;
	}

	public int getQuantidadeAlternativasPorQuestao() {
		return quantidadeAlternativasPorQuestao;
	}

	public void setQuantidadeAlternativasPorQuestao(int quantidadeAlternativasPorQuestao) {
		this.quantidadeAlternativasPorQuestao = quantidadeAlternativasPorQuestao;
	}

}
