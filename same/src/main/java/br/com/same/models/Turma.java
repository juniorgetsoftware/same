package br.com.same.models;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Table(name = "turma")
@Entity(name = "turma")
public class Turma extends EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 5, max = 255)
	@Column(nullable = false)
	private String nome;

	@Size(min = 5, max = 255)
	private String descricao;

	@ManyToOne(targetEntity = PeriodoLetivo.class)
	@JoinColumn(name = "periodo_letivo_id", nullable = false)
	private PeriodoLetivo periodoLetivo;

	@ManyToMany(targetEntity = Aluno.class)
	@JoinTable(name = "turma_aluno", joinColumns = { @JoinColumn(name = "turma_id") }, inverseJoinColumns = {
			@JoinColumn(name = "aluno_id") })
	private List<Aluno> alunos;

	//

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PeriodoLetivo getPeriodoLetivo() {
		return periodoLetivo;
	}

	public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public List<Aluno> getAlunos() {
		if (isNull(alunos))
			alunos = new ArrayList<>();
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Produces
	public Turma getInstancia() {
		return new Turma();
	}

	public void adicionar(Aluno aluno) {
		if (aluno == null) {
			throw new RuntimeException("O aluno é inválida");
		}
		this.getAlunos().add(aluno);
	}

	public void atualizar(Aluno aluno) {
		int index = this.getAlunos().indexOf(aluno);
		this.getAlunos().set(index, aluno);
	}

	public void remover(Aluno aluno) {
		this.getAlunos().remove(aluno);
	}
}
