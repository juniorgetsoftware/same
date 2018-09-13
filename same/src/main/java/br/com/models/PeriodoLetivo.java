package br.com.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "periodo_letivo")
@Table(name = "periodo_letivo")
public class PeriodoLetivo extends EntidadeBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1553763097213451896L;

	public PeriodoLetivo() {
		this.turmas = new ArrayList<>();
	}

	public PeriodoLetivo(int ano) {
		this();
		this.ano = ano;
	}

	public PeriodoLetivo(int ano, LocalDate dataInicio, LocalDate dataTermino) {
		this(ano);
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

	
	private int ano;
	private String titulo;
	private String descricao;
	@Transient
	private LocalDate dataInicio;
	@Transient
	private LocalDate dataTermino;
	@Transient
	private List<Turma> turmas;

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	//

	public void adicionar(Turma turma) {
		this.turmas.add(turma);
	}

	public void remover(Turma turma) {
		this.turmas.remove(turma);
	}

}
