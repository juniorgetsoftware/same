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
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;

@Table(name = "prova")
@Entity(name = "prova")
public class Prova extends EntidadeBase implements Serializable {

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

	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "prova", cascade = { CascadeType.ALL }, targetEntity = Questao.class, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Questao> questoes;

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

	public List<Questao> getQuestoes() {
		if (isNull(questoes))
			questoes = new ArrayList<>();
		return questoes;
	}

	public void setQuestoes(ArrayList<Questao> questoes) {
		this.questoes = questoes;
	}

	public void adicionar(Questao questao) {
		if (questao == null) {
			throw new RuntimeException("A questão é inválida");
		}
		questao.setProva(this);
		this.getQuestoes().add(questao);
	}

	public void adicionar(Questao... questoes) {
		if (questoes == null) {
			throw new RuntimeException("As questões são inválidas");
		}
		Stream.of(questoes).forEach(a -> a.setProva(this));
		this.getQuestoes().addAll(asList(questoes));
	}

	public void atualizar(Questao questao) {
		questao.setProva(this);
		int index = this.getQuestoes().indexOf(questao);
		this.getQuestoes().set(index, questao);
	}

	public void remover(Questao questao) {
		this.getQuestoes().remove(questao);
		questao.setProva(null);
	}

	public void gerarCamposDaProva(int quantidadeQuestoes, int quantidadeAlternativasPorQuestao) {
		for (int i = 0; i < quantidadeQuestoes; i++) {
			this.adicionarQuestaoEmBranco();
			for (int j = 0; j < quantidadeAlternativasPorQuestao; j++) {
				this.getQuestoes().get(i).adicionarAlternativaEmBranco();
			}
		}
	}

	/**
	 * Gera o gabarito de uma prova
	 * 
	 * @return um gabarito preenchido com repsentaçãode questões, alternativas de
	 *         resposta.
	 */
	public Gabarito gerarGabarito() {
		
		Gabarito gabarito = new Gabarito(this.getTitulo(), getObservacao(), this);
		
		for (int i = 0; i < getQuestoes().size(); i++) {
			
			Questao questao = getQuestoes().get(i);

			for (int j = 0; j < questao.getAlternativas().size(); j++) {
				
				Alternativa alternativa = questao.getAlternativas().get(j);
				
				if (alternativa.isResposta()) {
					gabarito.getGabaritoQuestoesAlternativas().add(new GabaritoQuestaoAlternativa(gabarito, questao, alternativa));
				}
				
			}
		}
		return gabarito;
	}

	public void adicionarQuestaoEmBranco() {
		this.adicionar(new Questao());
	}

	@Override
	public String toString() {
		return "Prova [titulo=" + titulo + ", questoes=" + questoes + "]";
	}

}
