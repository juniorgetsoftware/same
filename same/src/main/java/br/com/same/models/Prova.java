package br.com.same.models;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

@Table(name = "prova")
@Entity(name = "prova")
public class Prova implements Serializable {

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
	private String titulo;
	
	@NotBlank
	@Size(min = 5, max = 1000)
	@Column(nullable = false)
	private String observacao;
	
	@OneToMany(mappedBy = "prova", cascade = {
			CascadeType.ALL }, targetEntity = Questao.class, orphanRemoval = true)
	private List<Questao> questoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Questao> getQuestoes() {
		if (isNull(questoes))
			questoes = new ArrayList<>();
		return questoes;
	}

	public void setQuestoes(ArrayList<Questao> questoes) {
		this.questoes = questoes;
	}
	
	public void adicionar(Questao questao) {
		if (questao == null) {
			throw new RuntimeException("A questão é inválida");
		}
		questao.setProva(this);
		this.getQuestoes().add(questao);
	}

	public void atualizar(Questao questao) {
		questao.setProva(this);
		int index = this.getQuestoes().indexOf(questao);
		this.getQuestoes().set(index, questao);
	}

	public void remover(Questao questao) {
		this.getQuestoes().remove(questao);
		questao.setProva(null);
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
		Prova other = (Prova) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void gerarCamposDaProva(int quantidadeQuestoes, int quantidadeAlternativasPorQuestao) {
		for (int i = 0; i < quantidadeQuestoes; i++) {
			this.adicionar(new Questao());
			for (int j = 0; j < quantidadeAlternativasPorQuestao; j++) {
				this.getQuestoes().get(i).adicionar(new Alternativa());
			}
		}
	}

	@Override
	public String toString() {
		return "Prova [titulo=" + titulo + ", questoes=" + questoes + "]";
	}

}
