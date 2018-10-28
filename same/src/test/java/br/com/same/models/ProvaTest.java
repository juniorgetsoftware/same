package br.com.same.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProvaTest {

	@Test
	public void deveGerarGabaritoParaProva() {
		Prova prova = new Prova();
		
		Questao questao1 = new Questao();
		Alternativa alternativa11 = new Alternativa(true);
		Alternativa alternativa12 = new Alternativa();
		Alternativa alternativa13 = new Alternativa();
		
		questao1.adicionar(alternativa11, alternativa12, alternativa13);
		
		Questao questao2 = new Questao();
		Alternativa alternativa21 = new Alternativa();
		Alternativa alternativa22 = new Alternativa(true);
		Alternativa alternativa23 = new Alternativa();
		
		questao2.adicionar(alternativa21, alternativa22, alternativa23);
		prova.adicionar(questao1, questao2);
		
		Gabarito gabarito = prova.gerarGabarito();
		
		assertEquals(prova.getQuestoes().size(), gabarito.getGabaritoQuestoesAlternativas().size());
	}
	
	

}
