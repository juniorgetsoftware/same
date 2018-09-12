package br.com.same.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "questao")
@Table(name = "questao")
public class Questao extends EntidadeBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@Enumerated(EnumType.STRING)
	private NivelDificuldadeQuestao nivelDificuldadeQuestao;
	@OneToMany
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
