package br.com.same.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "aluno_gabarito")
@Table(name = "aluno_gabarito")
public class AlunoGabarito extends EntidadeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4738055469151750724L;

	@OneToOne( orphanRemoval = true)
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "gabarito_id")
	private Gabarito gabarito;

	public AlunoGabarito() {
	}

	public AlunoGabarito(Aluno aluno, Gabarito gabarito) {
		this.aluno = aluno;
		this.gabarito = gabarito;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Gabarito getGabarito() {
		return gabarito;
	}

	public void setGabarito(Gabarito gabarito) {
		this.gabarito = gabarito;
	}
}
