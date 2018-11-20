package br.com.same.models;

import static java.util.Arrays.asList;
import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;

@Table(name = "questao")
@Entity(name = "questao")
public class Questao extends EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	// @Size(min = 5, max = 255)
	@Column(nullable = false)
	private String enunciado;

	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "questao", cascade = {
			CascadeType.ALL }, targetEntity = Alternativa.class, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Alternativa> alternativas;

	@ManyToOne(targetEntity = Prova.class)
	@JoinColumn(name = "prova_id", nullable = false)
	private Prova prova;

	@OneToOne()
	@JoinColumn(nullable = false, name = "habilidade_id")
	private Habilidade habilidade;

	//

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<Alternativa> getAlternativas() {
		if (isNull(alternativas))
			alternativas = new ArrayList<>();
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public Prova getProva() {
		if (isNull(prova))
			prova = new Prova();
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public void adicionar(Alternativa alternativa) {
		if (alternativa == null) {
			throw new RuntimeException("A alternativa é inválida");
		}
		alternativa.setQuestao(this);
		this.getAlternativas().add(alternativa);
	}

	public void adicionar(Alternativa... alternativas) {
		if (alternativas == null) {
			throw new RuntimeException("A alternativa é inválida");
		}
		Stream.of(alternativas).forEach(a -> a.setQuestao(this));
		this.getAlternativas().addAll(asList(alternativas));
	}

	public void atualizar(Alternativa alternativa) {
		alternativa.setQuestao(this);
		int index = this.getAlternativas().indexOf(alternativa);
		this.getAlternativas().set(index, alternativa);
	}

	public void remover(Alternativa alternativa) {
		this.getAlternativas().remove(alternativa);
		alternativa.setQuestao(null);
	}

	public void adicionarAlternativaEmBranco() {
		this.adicionar(new Alternativa());
	}

	public Habilidade getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}

	@Override
	public String toString() {
		return "Questao [enunciado=" + enunciado + "] ";
	}
}
