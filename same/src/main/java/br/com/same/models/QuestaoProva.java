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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Table(name = "questao_prova")
@Entity(name = "questao_prova")
public class QuestaoProva extends EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 5, max = 255)
	@Column(nullable = false)
	private String enunciado;

	@OneToMany(mappedBy = "questao", cascade = {
			CascadeType.ALL }, targetEntity = AlternativaProva.class, orphanRemoval = true)
	private List<AlternativaProva> alternativas;

	@ManyToOne(targetEntity = Prova.class)
	@JoinColumn(name = "prova_id", nullable = false)
	private Prova prova;

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<AlternativaProva> getAlternativas() {
		if (isNull(alternativas))
			alternativas = new ArrayList<>();
		return alternativas;
	}

	public void setAlternativas(List<AlternativaProva> alternativas) {
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

	public void adicionar(AlternativaProva alternativa) {
		if (alternativa == null) {
			throw new RuntimeException("A alternativa é inválida");
		}
		alternativa.setQuestao(this);
		this.getAlternativas().add(alternativa);
	}

	public void adicionar(AlternativaProva... alternativas) {
		if (alternativas == null) {
			throw new RuntimeException("A alternativa é inválida");
		}
		Stream.of(alternativas).forEach(a -> a.setQuestao(this));
		this.getAlternativas().addAll(asList(alternativas));
	}

	public void atualizar(AlternativaProva alternativa) {
		alternativa.setQuestao(this);
		int index = this.getAlternativas().indexOf(alternativa);
		this.getAlternativas().set(index, alternativa);
	}

	public void remover(AlternativaProva alternativa) {
		this.getAlternativas().remove(alternativa);
		alternativa.setQuestao(null);
	}

	public void adicionarAlternativaEmBranco() {
		this.adicionar(new AlternativaProva());
	}

	@Override
	public String toString() {
		return "Questao [enunciado=" + enunciado + ", alternativas=" + alternativas + "]";
	}
}
