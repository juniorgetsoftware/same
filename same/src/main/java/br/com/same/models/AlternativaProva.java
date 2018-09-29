package br.com.same.models;

import static java.util.Objects.isNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Table(name = "alternativa_prova")
@Entity(name = "alternativa_prova")
public class AlternativaProva implements Serializable {

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
	private String descricao;

	private boolean resposta;

	@ManyToOne(targetEntity = QuestaoProva.class)
	@JoinColumn(name = "questao_prova_id", nullable = false)
	private QuestaoProva questao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		if (isNull(questao)) questao = new QuestaoProva();
		return questao;
	}

	public void setQuestao(QuestaoProva questao) {
		this.questao = questao;
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
		AlternativaProva other = (AlternativaProva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alternativa [descricao=" + descricao + ", resposta=" + resposta + "]";
	}

}