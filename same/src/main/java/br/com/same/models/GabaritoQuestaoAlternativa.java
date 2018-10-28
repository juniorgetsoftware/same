package br.com.same.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "gabarito_questao_alternativa")
@Table(name = "gabarito_questao_alternativa")
public class GabaritoQuestaoAlternativa extends EntidadeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GabaritoQuestaoAlternativa() {
	}

	public GabaritoQuestaoAlternativa(Gabarito gabarito, Questao questao, Alternativa alternativa) {
		super();
		this.gabarito = gabarito;
		this.questao = questao;
		this.alternativa = alternativa;
	}

	@ManyToOne()
	@JoinColumn(name = "gabarito_id", nullable = false)
	private Gabarito gabarito;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "questao_id", nullable = false)
	private Questao questao;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "alternativa_id", nullable = false)
	private Alternativa alternativa;

	//

	public Gabarito getGabarito() {
		return gabarito;
	}

	public void setGabarito(Gabarito gabarito) {
		this.gabarito = gabarito;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}

}
