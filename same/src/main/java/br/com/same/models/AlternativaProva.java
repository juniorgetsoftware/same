package br.com.same.models;

import static java.util.Objects.isNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Table(name = "alternativa_prova")
@Entity(name = "alternativa_prova")
public class AlternativaProva extends EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 5, max = 255)
	@Column(nullable = false)
	private String descricao;

	private boolean resposta;

	@ManyToOne(targetEntity = QuestaoProva.class)
	@JoinColumn(name = "questao_prova_id", nullable = false)
	private QuestaoProva questao;

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

	public QuestaoProva getQuestao() {
		if (isNull(questao))
			questao = new QuestaoProva();
		return questao;
	}

	public void setQuestao(QuestaoProva questao) {
		this.questao = questao;
	}

	@Override
	public String toString() {
		return "Alternativa [descricao=" + descricao + ", resposta=" + resposta + "]";
	}

}
