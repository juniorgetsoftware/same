package br.com.same.models;

import static java.util.Arrays.asList;
import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

	public Gabarito() {}
	
	public Gabarito(String titulo) {
		this.titulo = titulo;
	}

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

	/**
	 * Gera o gabarito de uma prova
	 * 
	 * @return um gabarito preenchido com repsentaçãode questões, alternativas de
	 *         resposta.
	 * @param prova
	 *            Prova para o qual ogabarito deve ser gerado.
	 */
	public Gabarito gerarGabaritoPorProva(Prova prova) {
		if (isNull(prova))
			throw new RuntimeException("A Prova é inválida");
		this.setTitulo(prova.getTitulo());
		this.setObservacao("Gabarito da pova '" + prova.getTitulo()+"'.");
		for (int i = 0; i < prova.getQuestoes().size(); i++) {
			QuestaoGabarito questaoGabarito = this.adicionarQuestaoComEnunciado(i);
			List<AlternativaProva> alternativasQuestaoProva = prova.getQuestoes().get(i).getAlternativas();
			for (int j = 0; j < alternativasQuestaoProva.size(); j++) {
				AlternativaProva alternativaProva = alternativasQuestaoProva.get(j);
				questaoGabarito.adicionarAlternativaComDescricaoEResposta(j, alternativaProva.isResposta());
			}
		}
		return this;
	}

	/**
	 * Utilizado para gerar automaticamenete um gabarito. Neste caso, é um gabaito
	 * independente, não estando relacionado a uma prova.
	 * 
	 * @param quantidadeQuestoes
	 *            Quantidade de questões que serão geradas
	 * @param quantidadeAlternativasPorQuestao
	 *            Quantidade de altermativas por questão
	 */
	public void gerarCamposDoGabarito(int quantidadeQuestoes, int quantidadeAlternativasPorQuestao) {
		for (int i = 0; i < quantidadeQuestoes; i++) {
			adicionarQuestaoComEnunciado(i + 1);
			for (int j = 0; j < quantidadeAlternativasPorQuestao; j++) {
				this.getQuestoes().get(i).adicionarAlternativaComDescricao(j);
			}
		}
	}

	/**
	 * Adiciona uma questão em branco. Nenhum atributo é preenchido.
	 */
	public void adicionarQuestaoEmBranco() {
		this.getQuestoes().add(new QuestaoGabarito());
	}

	/**
	 * Adiciona uma questão ao gabarito. Apenas o campo enunciado é preenchido.
	 * 
	 * @param indice
	 *            Reprensenta o índice/letra de posição da questão, dentro do
	 *            gabarito.
	 */
	public QuestaoGabarito adicionarQuestaoComEnunciado(int indice) {
		QuestaoGabarito questaoGabarito = new QuestaoGabarito("Questão " + indice);
		this.adicionar(questaoGabarito);
		return questaoGabarito;
	}

	// public void adicionar

	public void adicionar(QuestaoGabarito questaoGabarito) {
		if (isNull(questaoGabarito))
			throw new RuntimeException("Questao inválida");
		questaoGabarito.setGabarito(this);
		this.getQuestoes().add(questaoGabarito);
	}
	
	public void adicionar(QuestaoGabarito... questoes) {
		if (isNull(questoes))
			throw new RuntimeException("Questões inválidas");
		Stream.of(questoes).forEach(a -> a.setGabarito(this));
		this.getQuestoes().addAll(asList(questoes));
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
