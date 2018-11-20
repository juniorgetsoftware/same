package br.com.same.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "periodo_letivo")
@Table(name = "periodo_letivo")
public class PeriodoLetivo extends EntidadeBase {

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

	@ManyToOne(targetEntity = Escola.class)
	@JoinColumn(name = "escola_id", nullable = false)
	private Escola escola;

	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "periodoLetivo", cascade = {}, targetEntity = Turma.class, orphanRemoval = true)
	private List<Turma> turmas;

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

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public void adicionar(Turma turma) {
		if (turma == null) {
			throw new RuntimeException("A Turma é inválida");
		}
		turma.setPeriodoLetivo(this);
		this.getTurmas().add(turma);
	}

	public void atualizar(Turma turma) {
		turma.setPeriodoLetivo(this);
		int index = this.getTurmas().indexOf(turma);
		this.getTurmas().set(index, turma);
	}

	public void remover(Turma turma) {
		this.getTurmas().remove(turma);
		turma.setPeriodoLetivo(null);
	}
}
