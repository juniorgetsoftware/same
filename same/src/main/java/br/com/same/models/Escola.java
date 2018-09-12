package br.com.same.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "escola")
@Table(name = "escola")
public class Escola extends EntidadeBase implements Serializable {

	private static final long serialVersionUID = 1L;

	public Escola() {

	}

	public Escola(String nome) {
		this();
		this.nome = nome;
	}

	private String nome;

	@Transient
	private List<PeriodoLetivo> periodosLetivos;

	@Transient
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
