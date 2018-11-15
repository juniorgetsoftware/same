package br.com.same.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "aluno_prova_questao_alternativa")
@Entity(name = "aluno_prova_questao_alternativa")
public class AlunoProvaQuestaoAlternativa extends EntidadeBase {

	private static final long serialVersionUID = 1L;

	public AlunoProvaQuestaoAlternativa() {
	}

	public AlunoProvaQuestaoAlternativa(AlunoProva alunoProva, Questao questaoProva, Alternativa alternativaProva) {
		super();
		this.alunoProva = alunoProva;
		this.questaoProva = questaoProva;
		this.alternativaProva = alternativaProva;
	}

	@ManyToOne()
	@JoinColumn(name = "aluno_prova_id")
	private AlunoProva alunoProva;

	@OneToOne()
	@JoinColumn(name = "questao_id")
	private Questao questaoProva;

	@OneToOne()
	@JoinColumn(name = "alternativa_id")
	private Alternativa alternativaProva;

	//

	public Questao getQuestaoProva() {
		return questaoProva;
	}

	public void setQuestaoProva(Questao questaoProva) {
		this.questaoProva = questaoProva;
	}

	public Alternativa getAlternativaProva() {
		return alternativaProva;
	}

	public void setAlternativaProva(Alternativa alternativaProva) {
		this.alternativaProva = alternativaProva;
	}
}
