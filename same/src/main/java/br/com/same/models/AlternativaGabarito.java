package br.com.same.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Table(name = "alternativa_gabarito")
@Entity(name = "alternativa_gabarito")
public class AlternativaGabarito extends EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlternativaGabarito() {

	}

	public AlternativaGabarito(String descricao) {
		this.descricao = descricao;
	}

	public AlternativaGabarito(String descricao, boolean resposta) {
		this.descricao = descricao;
		this.resposta = resposta;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false)
	private String descricao;

	private boolean resposta;

	@ManyToOne(targetEntity = QuestaoGabarito.class)
	@JoinColumn(name = "questao_gabarito_id", nullable = false)
	private QuestaoGabarito questaoGabarito;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "alternativa_prova_id")
	private AlternativaProva alternativaProva;

	//

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}

	public QuestaoGabarito getQuestaoGabarito() {
		return questaoGabarito;
	}

	public void setQuestaoGabarito(QuestaoGabarito questaoGabarito) {
		this.questaoGabarito = questaoGabarito;
	}
	
	public AlternativaProva getAlternativaProva() {
		return alternativaProva;
	}

	public void setAlternativaProva(AlternativaProva alternativaProva) {
		this.alternativaProva = alternativaProva;
	}

	@Override
	public String toString() {
		return "AlternativaGabarito [descricao=" + descricao + ", resposta=" + resposta + "]";
	}

}
