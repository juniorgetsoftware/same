package br.com.same.models;

import static java.util.Objects.isNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Table(name = "alternativa")
@Entity(name = "alternativa")
public class Alternativa extends EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Alternativa() {
		
	}
	
	public Alternativa(boolean resposta) {
		this.resposta = resposta;
	}

	public Alternativa(String descricao, boolean resposta) {
		this.descricao = descricao;
		this.resposta = resposta;
	}
	
	@NotBlank
//	@Size(min = 5, max = 255)
	@Column(nullable = false)
	private String descricao;

	private boolean resposta;

	@ManyToOne(targetEntity = Questao.class)
	@JoinColumn(name = "questao_id", nullable = false)
	private Questao questao;

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

	public Questao getQuestao() {
		if (isNull(questao))
			questao = new Questao();
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	@Override
	public String toString() {
		return "Alternativa [descricao=" + descricao + ", resposta=" + resposta + "]";
	}

}
