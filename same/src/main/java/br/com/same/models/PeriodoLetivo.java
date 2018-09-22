package br.com.same.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "periodo_letivo")
@Table(name = "periodo_letivo")
public class PeriodoLetivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 5, max = 255)
	@Column(nullable = false)
	private String nome;

	@Size(min = 5, max = 255)
	private String descricao;

	@ManyToOne(targetEntity = Escola.class)
	@JoinColumn(name = "escola_id", nullable = false)
	private Escola escola;

	@OneToMany(mappedBy = "periodoLetivo", cascade = {
			CascadeType.ALL }, targetEntity = Turma.class, orphanRemoval = true)
	private List<Turma> turmas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeriodoLetivo other = (PeriodoLetivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void adicionar(Turma turma) {
		if (turma == null) {
			throw new RuntimeException("A Turma é inválida");
		}
		turma.setPeriodoLetivo(this);
		this.getTurmas().add(turma);
	}

	public void atualizar(Turma turma) {
		int index = this.getTurmas().indexOf(turma);
		this.getTurmas().set(index, turma);
	}

	public void remover(Turma turma) {
		this.getTurmas().remove(turma);
	}
}
