package br.com.same.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.same.models.AlternativaGabarito;
import br.com.same.models.Aluno;
import br.com.same.models.AlunoGabarito;
import br.com.same.models.Escola;
import br.com.same.models.Gabarito;
import br.com.same.models.PeriodoLetivo;
import br.com.same.models.QuestaoGabarito;
import br.com.same.models.Turma;
import br.com.same.services.AlunoService;
import br.com.same.services.EscolaService;
import br.com.same.services.GabaritoService;
import br.com.same.services.PeriodoLetivoService;
import br.com.same.services.TurmaService;

@Named
@ViewScoped
public class CorrecaoCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EscolaService escolaService;

	@Inject
	private PeriodoLetivoService periodoLetivoService;

	@Inject
	private TurmaService turmaService;

	@Inject
	private GabaritoService gabaritoService;

	@Inject
	private AlunoService alunoService;
	
	//

	private List<Escola> escolas;
	private Escola escola;

	public void listarEscolas() {
		escolas = escolaService.listar();
	}

	private PeriodoLetivo periodo;
	private List<PeriodoLetivo> periodos;

	public void listarPeriodos() {
		periodos = periodoLetivoService.listar(escola);
	}

	private List<Turma> turmas;
	private Turma turma;

	public void listarTurmas() {
		turmas = turmaService.listar(periodo);
	}

	private List<Gabarito> gabaritos;
	private Gabarito gabarito;

	public void listarGabaritos() {
		gabaritos = gabaritoService.listar(/*turma*/);
	}
	
	private List<Aluno> alunos;

	public void listarAlunos() {
		alunos = alunoService.listar(/*turma*/);
	}
	
	//

//	private Gabarito gabaritoMock;
	private List<AlunoGabarito> alunoGabaritos;

	@PostConstruct
	public void init() {
		listarEscolas();
	}

	public void gerarGabarito() {
//		gabaritoMock = gabarito();
//		alunos = listaDeAlunos();
		listarAlunos();
		alunoGabaritos = alunoGabaritos(alunos, gabarito);
	}

	public List<AlunoGabarito> alunoGabaritos(List<Aluno> list, Gabarito gabarito) {
		List<AlunoGabarito> alunoGabaritos = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			alunoGabaritos.add(new AlunoGabarito(list.get(i), gabarito));
		}
		return alunoGabaritos;
	}

//	private List<Aluno> listaDeAlunos() {
//		return Arrays.asList(new Aluno("Amadeu Salguero"), new Aluno("Armindo Neto"), new Aluno("Caetano Sabrosa"),
//				new Aluno("Damião Belém"), new Aluno("Danilo Saraíba"), new Aluno("Eduardo Filgueiras"),
//				new Aluno("Fernanda Cordero"), new Aluno("Félix Penha"), new Aluno("Jordão Damazio"),
//				new Aluno("Josefina Penha"), new Aluno("Lua Correa"), new Aluno("Marcela Olivares"),
//				new Aluno("Marcela Vidal"), new Aluno("Martim Fiestas"), new Aluno("Nuno Fontes"),
//				new Aluno("Otília Cesário"), new Aluno("Porfírio Carrasco"), new Aluno("Raquel Abranches"),
//				new Aluno("Remo Sousa"), new Aluno("Salvina Jordão"), new Aluno("Serafim Câmara"),
//				new Aluno("Taíssa Costa"));
//	}

//	private Gabarito gabarito() {
//		Gabarito gabarito = new Gabarito("Prova de matemática");
//
//		QuestaoGabarito q1 = new QuestaoGabarito("Q1");
//		AlternativaGabarito a11 = new AlternativaGabarito("A", true);
//		AlternativaGabarito a12 = new AlternativaGabarito("B");
//		AlternativaGabarito a13 = new AlternativaGabarito("C");
//		AlternativaGabarito a14 = new AlternativaGabarito("D");
//		AlternativaGabarito a15 = new AlternativaGabarito("E");
//		q1.adicionar(a11, a12, a13, a14, a15);
//
//		QuestaoGabarito q2 = new QuestaoGabarito("Q2");
//		AlternativaGabarito a21 = new AlternativaGabarito("A", true);
//		AlternativaGabarito a22 = new AlternativaGabarito("B");
//		AlternativaGabarito a23 = new AlternativaGabarito("C");
//		AlternativaGabarito a24 = new AlternativaGabarito("D");
//		AlternativaGabarito a25 = new AlternativaGabarito("E");
//		q2.adicionar(a21, a22, a23, a24, a25);
//
//		QuestaoGabarito q3 = new QuestaoGabarito("Q3");
//		AlternativaGabarito a31 = new AlternativaGabarito("A");
//		AlternativaGabarito a32 = new AlternativaGabarito("B");
//		AlternativaGabarito a33 = new AlternativaGabarito("C");
//		AlternativaGabarito a34 = new AlternativaGabarito("D");
//		AlternativaGabarito a35 = new AlternativaGabarito("E", true);
//		q3.adicionar(a31, a32, a33, a34, a35);
//
//		QuestaoGabarito q4 = new QuestaoGabarito("Q4");
//		AlternativaGabarito a41 = new AlternativaGabarito("A");
//		AlternativaGabarito a42 = new AlternativaGabarito("B");
//		AlternativaGabarito a43 = new AlternativaGabarito("C", true);
//		AlternativaGabarito a44 = new AlternativaGabarito("D");
//		AlternativaGabarito a45 = new AlternativaGabarito("E");
//		q4.adicionar(a41, a42, a43, a44, a45);
//
//		QuestaoGabarito q5 = new QuestaoGabarito("Q5");
//		AlternativaGabarito a51 = new AlternativaGabarito("A");
//		AlternativaGabarito a52 = new AlternativaGabarito("B");
//		AlternativaGabarito a53 = new AlternativaGabarito("C");
//		AlternativaGabarito a54 = new AlternativaGabarito("D");
//		AlternativaGabarito a55 = new AlternativaGabarito("E", true);
//		q5.adicionar(a51, a52, a53, a54, a55);
//
//		gabarito.adicionar(q1, q2, q3, q4, q5);
//
//		return gabarito;
//	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

//	public Gabarito getGabaritoMock() {
//		return gabaritoMock;
//	}
//
//	public void setGabaritoMock(Gabarito gabarito) {
//		this.gabaritoMock = gabarito;
//	}

	public List<AlunoGabarito> getAlunoGabaritos() {
		return alunoGabaritos;
	}

	public void setAlunoGabaritos(List<AlunoGabarito> alunoGabaritos) {
		this.alunoGabaritos = alunoGabaritos;
	}

	public List<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public PeriodoLetivo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoLetivo periodo) {
		this.periodo = periodo;
	}

	public List<PeriodoLetivo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<PeriodoLetivo> periodos) {
		this.periodos = periodos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Gabarito> getGabaritos() {
		return gabaritos;
	}

	public void setGabaritos(List<Gabarito> gabaritos) {
		this.gabaritos = gabaritos;
	}

	public Gabarito getGabarito() {
		return gabarito;
	}

	public void setGabarito(Gabarito gabarito) {
		this.gabarito = gabarito;
	}
	
	//
	
}
