package br.com.same.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Questao extends EntidadeBase {

	public Questao() {
		this.respostas = new ArrayList<>();
	}

	public Questao(String enunciado) {
		this();
		this.enunciado = enunciado;
	}

	public Questao(String enunciado, NivelDificuldadeQuestao nivelDificuldadeQuestao) {
		this(enunciado);
		this.nivelDificuldadeQuestao = nivelDificuldadeQuestao;
	}

	private String enunciado;
	private NivelDificuldadeQuestao nivelDificuldadeQuestao;
	private List<Resposta> respostas;

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public NivelDificuldadeQuestao getNivelDificuldadeQuestao() {
		return nivelDificuldadeQuestao;
	}

	public void setNivelDificuldadeQuestao(NivelDificuldadeQuestao nivelDificuldadeQuestao) {
		this.nivelDificuldadeQuestao = nivelDificuldadeQuestao;
	}

	public void adicionar(Resposta resposta) {
		this.respostas.add(resposta);
	}

	public void remover(Resposta resposta) {
		this.respostas.remove(resposta);
	}

	public void adicionar(Resposta... respostas) {
		this.respostas.addAll(Arrays.asList(respostas));
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

}
