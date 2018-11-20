package br.com.same.models;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;

@Table(name = "escola")
@Entity(name = "escola")
public class Escola extends EntidadeBase implements Serializable {

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

	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "escola", cascade = {}, targetEntity = PeriodoLetivo.class, orphanRemoval = true)
	private List<PeriodoLetivo> periodosLetivo;

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
