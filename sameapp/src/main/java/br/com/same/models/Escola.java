package br.com.same.models;

import java.util.ArrayList;
import java.util.List;

public class Escola extends EntidadeBase {

	public Escola() {
		this.periodosLetivos = new ArrayList<>();
	}

	public Escola(String nome) {
		this();
		this.nome = nome;
	}

	private String nome;
	private List<PeriodoLetivo> periodosLetivos;
	private Endereco endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	//

	public void adicionar(PeriodoLetivo periodoLetivo) {
		this.periodosLetivos.add(periodoLetivo);
	}

	public void remove(PeriodoLetivo periodoLetivo) {
		this.periodosLetivos.remove(periodoLetivo);
	}

}
