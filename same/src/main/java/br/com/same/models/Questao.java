package br.com.same.models;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "questao")
@Entity(name = "questao")
public class Questao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String enunciado;

	@OneToMany(mappedBy = "questao", cascade = {
			CascadeType.ALL }, targetEntity = Alternativa.class, orphanRemoval = true)
	private List<Alternativa> alternativas;

	@ManyToOne(targetEntity = Prova.class)
	@JoinColumn(name = "prova_id", nullable = false)
	private Prova prova;

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

	public List<Alternativa> getAlternativas() {
		if (isNull(alternativas))
			alternativas = new ArrayList<>();
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public Prova getProva() {
		if (isNull(prova)) prova = new Prova();
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
		this.getAlternativas().add(new Alternativa());
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
		Questao other = (Questao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Questao [enunciado=" + enunciado + ", alternativas=" + alternativas + "]";
	}

}
