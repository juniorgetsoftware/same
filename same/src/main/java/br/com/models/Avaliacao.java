package br.com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "avaliacao")
@Table(name = "avaliacao")
public class Avaliacao extends EntidadeBase implements Serializable {

	public Avaliacao() {
		this.provas = new ArrayList<>();
		this.habilidades = new ArrayList<>();
	}

	public Avaliacao(String nome) {
		this();
		this.nome = nome;
	}

	private String nome;

	@OneToMany
	private List<Prova> provas;

	@OneToMany
	private List<Habilidade> habilidades;

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionar(Prova prova) {
		this.provas.add(prova);
	}

	public void adicionar(Prova... provas) {
		this.provas.addAll(Arrays.asList(provas));
	}

	public void remove(Prova prova) {
		this.provas.remove(prova);
	}

	public void adicionar(Habilidade habilidade) {
		this.habilidades.add(habilidade);
	}

	public void adicionar(Habilidade... habilidades) {
		this.habilidades.addAll(Arrays.asList(habilidades));
	}

	public void remove(Habilidade habilidade) {
		this.habilidades.remove(habilidade);
	}
}
