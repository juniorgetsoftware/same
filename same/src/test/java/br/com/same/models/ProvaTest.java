package br.com.same.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

public class ProvaTest {
	
	@Test
	public void deveGerarGabaritoParaProva() {
		Prova prova = new Prova();
		
		QuestaoProva questao1 = new QuestaoProva();
		AlternativaProva alternativa11 = new AlternativaProva();
		AlternativaProva alternativa12 = new AlternativaProva();
		AlternativaProva alternativa13 = new AlternativaProva();
		questao1.adicionar(alternativa11, alternativa12, alternativa13);
		
		QuestaoProva questao2 = new QuestaoProva();
		AlternativaProva alternativa21 = new AlternativaProva();
		AlternativaProva alternativa22 = new AlternativaProva();
		AlternativaProva alternativa23 = new AlternativaProva();
		questao2.adicionar(alternativa21, alternativa22, alternativa23);
		
		prova.adicionar(questao1, questao2);
		
		Gabarito gabarito = prova.gerarGabarito();
		
		assertEquals(prova.getQuestoes().size(), gabarito.getQuestoes().size());
		assertEquals(prova.getQuestoes().get(0).getAlternativas().size(), 
				gabarito.getQuestoes().get(0).getAlternativas().size());
		assertEquals(prova.getQuestoes().get(1).getAlternativas().size(), 
				gabarito.getQuestoes().get(1).getAlternativas().size());
	}

	@Test
	public void naoDeveTerQuestaoEmBrancoNoGabarito() {
		Prova prova = new Prova();
		
		QuestaoProva questao1 = new QuestaoProva();
		AlternativaProva alternativa11 = new AlternativaProva();
		AlternativaProva alternativa12 = new AlternativaProva();
		AlternativaProva alternativa13 = new AlternativaProva();
		questao1.adicionar(alternativa11, alternativa12, alternativa13);
		
		QuestaoProva questao2 = new QuestaoProva();
		AlternativaProva alternativa21 = new AlternativaProva();
		AlternativaProva alternativa22 = new AlternativaProva();
		AlternativaProva alternativa23 = new AlternativaProva();
		questao2.adicionar(alternativa21, alternativa22, alternativa23);
		
		prova.adicionar(questao1, questao2);
		
		Gabarito gabarito = prova.gerarGabarito();
		
		List<QuestaoGabarito> questoes = gabarito.getQuestoes();
		assertNotEquals(questoes.get(0).getEnunciado(), "");
		assertNotNull(questoes.get(0).getEnunciado());
		
	}
}
