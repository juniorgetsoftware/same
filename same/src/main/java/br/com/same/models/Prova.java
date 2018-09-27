package br.com.same.models;

import static java.util.Objects.isNull;

import java.util.ArrayList;

public class Prova {

	private Long id;
	private String titulo;
	private String observacao;
	private ArrayList<Questao> questoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ArrayList<Questao> getQuestoes() {
		if (isNull(questoes))
			questoes = new ArrayList<>();
		return questoes;
	}

	public void setQuestoes(ArrayList<Questao> questoes) {
		this.questoes = questoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prova other = (Prova) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void gerarCamposDaProva(int quantidadeQuestoes, int quantidadeAlternativasPorQuestao) {
		for (int i = 0; i < quantidadeQuestoes; i++) {
			this.getQuestoes().add(i, new Questao());
			for (int j = 0; j < quantidadeAlternativasPorQuestao; j++) {
				this.getQuestoes().get(i).getAlternativas().add(new Alternativa());
			}
		}
	}

	@Override
	public String toString() {
		return "Prova [titulo=" + titulo + ", questoes=" + questoes + "]";
	}

}
