package br.com.same.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;

@Table(name = "gabarito")
@Entity(name = "gabarito")
public class Gabarito extends EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 5, max = 255)
	@Column(nullable = false)
	private String titulo;

	@NotBlank
	@Size(min = 5, max = 1000)
	@Column(nullable = false)
	private String observacao;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "prova_id", nullable = false)
	private Prova prova;

	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "gabarito", cascade = {
			CascadeType.ALL }, targetEntity = GabaritoQuestaoAlternativa.class, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<GabaritoQuestaoAlternativa> gabaritoQuestoesAlternativas = new ArrayList<>();

	public Gabarito() {
	}

	public Gabarito(String titulo, String observacao, Prova prova) {
		super();
		this.titulo = titulo;
		this.observacao = observacao;
		this.prova = prova;
	}

	//

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

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public List<GabaritoQuestaoAlternativa> getGabaritoQuestoesAlternativas() {
		return gabaritoQuestoesAlternativas;
	}

	public void setGabaritoQuestoesAlternativas(List<GabaritoQuestaoAlternativa> gabaritoQuestoesAlternativas) {
		this.gabaritoQuestoesAlternativas = gabaritoQuestoesAlternativas;
	}
}
