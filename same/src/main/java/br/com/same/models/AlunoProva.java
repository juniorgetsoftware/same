package br.com.same.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "aluno_prova")
@Table(name = "aluno_prova")
public class AlunoProva extends EntidadeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4738055469151750724L;

	public AlunoProva() {
		super();
	}

	public AlunoProva(Aluno aluno, Prova prova/*, Questao questaoProva, Alternativa alternativaProva*/) {
		super();
		this.aluno = aluno;
		this.prova = prova;
//		this.questaoProva = questaoProva;
//		this.alternativaProva = alternativaProva;
	}

	@OneToOne()
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@OneToOne()
	@JoinColumn(name = "prova_id")
	private Prova prova;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "questao_alternativa", nullable = false)
	private List<AlunoProvaQuestaoAlternativa> questoesAlternativas = new ArrayList<>();

//	@OneToOne()
//	@JoinColumn(name = "questao_id")
//	private Questao questaoProva;
//
//	@OneToOne()
//	@JoinColumn(name = "alternativa_id")
//	private Alternativa alternativaProva;

	//

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

//	public Questao getQuestaoProva() {
//		return questaoProva;
//	}
//
//	public void setQuestaoProva(Questao questaoProva) {
//		this.questaoProva = questaoProva;
//	}
//
//	public Alternativa getAlternativaProva() {
//		return alternativaProva;
//	}
//
//	public void setAlternativaProva(Alternativa alternativaProva) {
//		this.alternativaProva = alternativaProva;
//	}

	
	@Override
	public String toString() {
		return "Aluno prova [" + aluno.getNome() + ", " + prova.getTitulo() + "]"; 
	}

	public List<AlunoProvaQuestaoAlternativa> getQuestoesAlternativas() {
		return questoesAlternativas;
	}

	public void setQuestoesAlternativas(List<AlunoProvaQuestaoAlternativa> questoesAlternativas) {
		this.questoesAlternativas = questoesAlternativas;
	}

}
