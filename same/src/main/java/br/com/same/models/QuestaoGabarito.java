package br.com.same.models;

import static br.com.same.utils.LetraUtil.letraPorIndice;
import static java.util.Objects.isNull;

import java.util.ArrayList;
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

@Table(name = "questao_gabarito")
@Entity(name = "questao_gabarito")
public class QuestaoGabarito {

	public QuestaoGabarito() {

	}

	public QuestaoGabarito(String enunciado) {
		this.enunciado = enunciado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 5, max = 255)
	@Column(nullable = false)
	private String enunciado;

	@ManyToOne(targetEntity = Gabarito.class)
	@JoinColumn(name = "gabarito_id", nullable = false)
	private Gabarito gabarito;

	@OneToMany(mappedBy = "questaoGabarito", cascade = {
			CascadeType.ALL }, targetEntity = AlternativaGabarito.class, orphanRemoval = true)
	private List<AlternativaGabarito> alternativas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Gabarito getGabarito() {
		return gabarito;
	}

	public void setGabarito(Gabarito gabarito) {
		this.gabarito = gabarito;
	}

	public List<AlternativaGabarito> getAlternativas() {
		if (isNull(alternativas))
			alternativas = new ArrayList<>();
		return alternativas;
	}

	public void setAlternativas(List<AlternativaGabarito> alternativas) {
		this.alternativas = alternativas;
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
		QuestaoGabarito other = (QuestaoGabarito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//

	/**
	 * Adiciona uma alternativa em branco. Nenhum atributo é preenchido
	 */
	public void adicionarAlternativaEmBranco() {
		this.getAlternativas().add(new AlternativaGabarito());
	}

	/**
	 * Adiciona uma alternativa. Apenas o campo descricao é preenchido.
	 * 
	 * @param indice
	 *            Representa a letra/índice de posição da alternativa na questão
	 */
	public void adicionarAlternativaComDescricao(int indice) {
		this.adicionar(new AlternativaGabarito("Alternativa " + letraPorIndice(indice)));
	}

	/**
	 * Adiciona uma alternativa. Os campos descrição e resposta certa são
	 * preenchidos
	 * 
	 * @param indice
	 *            Representa a letra/índice de posição da alternativa na questão
	 * @param resposta
	 *            Booleano indicando se a dada resposta é a resposta correta ou não.
	 *            true para resposta correta e false para errada.
	 */
	public void adicionarAlternativaComDescricaoEResposta(int indice, boolean resposta) {
		this.adicionar(new AlternativaGabarito("Alternativa " + letraPorIndice(indice), resposta));
	}

	public void adicionar(AlternativaGabarito alternativa) {
		if (isNull(alternativa))
			throw new RuntimeException("Alternativa inválida");
		alternativa.setQuestaoGabarito(this);
		this.getAlternativas().add(alternativa);
	}

	public void atualizar(AlternativaGabarito alternativa) {
		if (isNull(alternativa))
			throw new RuntimeException("Alternativa inválida");
		alternativa.setQuestaoGabarito(this);
		this.getAlternativas().add(alternativa);
	}

	public void remover(AlternativaGabarito alternativa) {
		if (isNull(alternativa))
			throw new RuntimeException("Alternativa inválida");
		alternativa.setQuestaoGabarito(null);
		this.getAlternativas().remove(alternativa);
	}

	@Override
	public String toString() {
		return "QuestaoGabarito [enunciado=" + enunciado + ", alternativas=" + alternativas + "]";
	}

}
