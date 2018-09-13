package br.com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "turma")
@Table(name = "turma")
public class Turma extends EntidadeBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Turma() {
		this.alunos = new ArrayList<>();
		this.professores = new ArrayList<>();
		this.disciplinas = new ArrayList<>();
	}

	public Turma(String nome, Turno turno) {
		this();
		this.nome = nome;
		this.turno = turno;
	}

	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Turno turno;
	@ManyToMany
	private List<Aluno> alunos;
	@ManyToMany
	private List<Professor> professores;
	@ManyToMany
	private List<Disciplina> disciplinas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	//

	public void adicionar(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public void adicionar(Aluno... alunos) {
		this.alunos.addAll(Arrays.asList(alunos));
	}

	public void remover(Aluno aluno) {
		this.alunos.remove(aluno);
	}

	public void adicionar(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}

	public void adicionar(Disciplina... disciplinas) {
		this.disciplinas.addAll(Arrays.asList(disciplinas));
	}

	public void remover(Disciplina disciplina) {
		this.disciplinas.remove(disciplina);
	}

	public void adicionar(Professor professor) {
		this.professores.add(professor);
	}

	public void adicionar(Professor... professores) {
		this.professores.addAll(Arrays.asList(professores));
	}

	public void remover(Professor professor) {
		this.professores.remove(professor);
	}

}
