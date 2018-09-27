package br.com.same.models;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Table(name = "escola")
@Entity(name = "escola")
public class Escola implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 5, max = 255)
	@Column(nullable = false)
	private String nome;

	@Size(min = 5, max = 255)
	private String descricao;

	@OneToMany(mappedBy = "escola", cascade = {
			CascadeType.ALL }, targetEntity = PeriodoLetivo.class, orphanRemoval = true)
	private List<PeriodoLetivo> periodosLetivo;

	//

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

	@Produces
	public Escola getInstancia() {
		return new Escola();
	}

	public List<PeriodoLetivo> getPeriodosLetivo() {
		if (isNull(periodosLetivo))
			periodosLetivo = new ArrayList<>();
		return periodosLetivo;
	}

	public void setPeriodosLetivo(List<PeriodoLetivo> periodosLetivo) {
		this.periodosLetivo = periodosLetivo;
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
		Escola other = (Escola) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void adicionar(PeriodoLetivo periodoLetivo) {
		if (periodoLetivo == null) {
			throw new RuntimeException("O Período Letivo é inválido");
		}
		periodoLetivo.setEscola(this);
		this.getPeriodosLetivo().add(periodoLetivo);
	}

	public void atualizar(PeriodoLetivo periodoLetivo) {
		periodoLetivo.setEscola(this);
		int index = this.getPeriodosLetivo().indexOf(periodoLetivo);
		this.getPeriodosLetivo().set(index, periodoLetivo);
	}

	public void remover(PeriodoLetivo periodoLetivo) {
		this.getPeriodosLetivo().remove(periodoLetivo);
		periodoLetivo.setEscola(null);
	}

}
