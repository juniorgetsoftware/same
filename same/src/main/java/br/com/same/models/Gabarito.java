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

@Table(name = "gabarito")
@Entity(name = "gabarito")
public class Gabarito implements Serializable {

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

	@OneToMany(mappedBy = "gabarito", cascade = {
			CascadeType.ALL }, targetEntity = QuestaoGabarito.class, orphanRemoval = true)
	private List<QuestaoGabarito> questoes;

	// private Escola escola;
	// private PeriodoLetivo periodoLetivo;
	// private Turma turma;
	// private Disciplina disciplina;
	// private Aluno aluno;

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

	// public Escola getEscola() {
	// return escola;
	// }
	//
	// public void setEscola(Escola escola) {
	// this.escola = escola;
	// }
	//
	// public PeriodoLetivo getPeriodoLetivo() {
	// return periodoLetivo;
	// }
	//
	// public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
	// this.periodoLetivo = periodoLetivo;
	// }
	//
	// public Turma getTurma() {
	// return turma;
	// }
	//
	// public void setTurma(Turma turma) {
	// this.turma = turma;
	// }
	//
	// public Disciplina getDisciplina() {
	// return disciplina;
	// }
	//
	// public void setDisciplina(Disciplina disciplina) {
	// this.disciplina = disciplina;
	// }
	//
	// public Aluno getAluno() {
	// return aluno;
	// }
	//
	// public void setAluno(Aluno aluno) {
	// this.aluno = aluno;
	// }

	public List<QuestaoGabarito> getQuestoes() {
		if (isNull(questoes))
			questoes = new ArrayList<>();
		return questoes;
	}

	public void setQuestoes(List<QuestaoGabarito> questoes) {
		this.questoes = questoes;
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
		Gabarito other = (Gabarito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void gerarCamposDoGabarito(int quantidadeQuestoes, int quantidadeAlternativasPorQuestao) {
		for (int i = 0; i < quantidadeQuestoes; i++) {
			adicionarQuestaoComTitulo(i + 1);
			for (int j = 0; j < quantidadeAlternativasPorQuestao; j++) {
				this.getQuestoes().get(i).adicionarAlternativaComEnunciado(j);
			}
		}
	}

	public void adicionarQuestaoEmBranco() {
		this.getQuestoes().add(new QuestaoGabarito());
	}

	public void adicionarQuestaoComTitulo(int indice) {
		this.adicionar(new QuestaoGabarito("Questão " + indice));
	}

	public void adicionar(QuestaoGabarito questaoGabarito) {
		if (isNull(questaoGabarito))
			throw new RuntimeException("Questao inválida");
		questaoGabarito.setGabarito(this);
		this.getQuestoes().add(questaoGabarito);
	}

	public void atualizar(QuestaoGabarito questaoGabarito) {
		if (isNull(questaoGabarito))
			throw new RuntimeException("Questao inválida");
		questaoGabarito.setGabarito(this);
		this.getQuestoes().add(questaoGabarito);
	}

	public void remover(QuestaoGabarito questaoGabarito) {
		if (isNull(questaoGabarito))
			throw new RuntimeException("Questao inválida");
		questaoGabarito.setGabarito(null);
		this.getQuestoes().remove(questaoGabarito);
	}

	@Override
	public String toString() {
		return "Gabarito [titulo=" + titulo + ", questoes=" + questoes + "]";
	}

}
