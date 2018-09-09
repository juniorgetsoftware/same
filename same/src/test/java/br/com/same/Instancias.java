package br.com.same;

import static br.com.same.models.NivelDificuldadeQuestao.DIFICIL;
import static br.com.same.models.NivelDificuldadeQuestao.FACIL;
import static br.com.same.models.NivelDificuldadeQuestao.INTERMIDIARIO;
import static br.com.same.models.NivelDificuldadeQuestao.MUIRO_DIFICIL;

import br.com.same.models.Aluno;
import br.com.same.models.Avaliacao;
import br.com.same.models.Disciplina;
import br.com.same.models.Escola;
import br.com.same.models.Gabarito;
import br.com.same.models.Habilidade;
import br.com.same.models.ItemHabilidade;
import br.com.same.models.PeriodoLetivo;
import br.com.same.models.Professor;
import br.com.same.models.Prova;
import br.com.same.models.Questao;
import br.com.same.models.Resposta;
import br.com.same.models.Turma;
import br.com.same.models.Turno;

public class Instancias {

	public static void main(String[] args) {

		/*ESCOLA*/
		Escola escola = new Escola("E. E. B. Capitão José Raimundo Evangelista");
		
		/*PRIODO LETIVO*/
		PeriodoLetivo periodoLetivo = new PeriodoLetivo(2018);
		
		/*TURMA*/
		Turma turma = new Turma("1º A", Turno.MATUTINO);

		/*ALUNO*/
		Aluno aluno = new Aluno("Wilton Junior");

		/*PROFESSOR*/
		Professor professor = new Professor("Lima Junior");

		/*DISCIPLINA*/
		Disciplina disciplina = new Disciplina("Matemática");

		/*PROVA*/
		Prova prova = new Prova("Prova de matemática");

		/*QUESTÃO*/
		Questao questao1 = new Questao("Qual o resultado da soma de \'1 + 1\'?", FACIL);
		Questao questao2 = new Questao("Qual o resultado da soma de \'2 + 2\'?", INTERMIDIARIO);
		Questao questao3 = new Questao("Qual o resultado da soma de \'3 + 3\'?", DIFICIL);
		Questao questao4 = new Questao("Qual o resultado da soma de \'4 + 4\'?", MUIRO_DIFICIL);
		
		/*RESPOSTA*/
		Resposta q1a = new Resposta("3");
		Resposta q1b = new Resposta("2", true);
		Resposta q1c = new Resposta("1");
		Resposta q1d = new Resposta("4");

		Resposta q2a = new Resposta("3");
		Resposta q2b = new Resposta("2");
		Resposta q2c = new Resposta("1");
		Resposta q2d = new Resposta("4", true);

		Resposta q3a = new Resposta("7");
		Resposta q3b = new Resposta("5");
		Resposta q3c = new Resposta("6", true);
		Resposta q3d = new Resposta("4");
		
		Resposta q4a = new Resposta("8", true);
		Resposta q4b = new Resposta("6");
		Resposta q4c = new Resposta("4");
		Resposta q4d = new Resposta("5");
		
		/*GABARITO*/
		Gabarito gabarito = new Gabarito(prova);

		/*AVALIAÇÃO*/
		Avaliacao avaliacao = new Avaliacao("Avaliação 1 - Primeiro semestre");

		/*HABILIDADE*/
		Habilidade habilidade1 = new Habilidade("Habilidades em potuguês");
		Habilidade habilidade2 = new Habilidade("Habilidades em matemática");
		
		/*ITEM HABILIDADE*/
		ItemHabilidade itemHabilidade1 = new ItemHabilidade("H1 - Analisar e comparar objetos por meio de representação fracionária.");
		ItemHabilidade itemHabilidade2 = new ItemHabilidade("H2 - Manipular frações equivalente.");
		ItemHabilidade itemHabilidade3 = new ItemHabilidade("H3 - Identificar frações próprias e imprópria.");
		ItemHabilidade itemHabilidade4 = new ItemHabilidade("H4 -  Realizar adição e subtração com números decimais.");

		/**/
		
		turma.adicionar(aluno);
		turma.adicionar(disciplina);
		turma.adicionar(professor);
		
		periodoLetivo.adicionar(turma);
		escola.adicionar(periodoLetivo);
		
		/**/
		
		questao1.adicionar(q1a, q1b, q1c, q1d);
		questao2.adicionar(q2a, q2b, q2c, q2d);
		questao3.adicionar(q3a, q3b, q3c, q3d);
		questao4.adicionar(q4a, q4b, q4c, q4d);
		
		prova.adicionar(questao1, questao2, questao3, questao4);
		avaliacao.adicionar(prova);
		gabarito.gabarito().forEach(System.out::println);

		/**/
		
		habilidade1.adicionar(itemHabilidade1, itemHabilidade2);
		habilidade2.adicionar(itemHabilidade3, itemHabilidade4);
		avaliacao.adicionar(habilidade1, habilidade2);

	}

}
