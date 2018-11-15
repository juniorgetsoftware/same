package br.com.same.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.same.models.Aluno;
import br.com.same.models.AlunoProva;
import br.com.same.models.AlunoProvaQuestaoAlternativa;
import br.com.same.models.Escola;
import br.com.same.models.PeriodoLetivo;
import br.com.same.models.Prova;
import br.com.same.models.Questao;
import br.com.same.models.Turma;
import br.com.same.services.AlunoService;
import br.com.same.services.EscolaService;
import br.com.same.services.GabaritoService;
import br.com.same.services.PeriodoLetivoService;
import br.com.same.services.ProvaService;
import br.com.same.services.Service;
import br.com.same.services.TurmaService;

@Named
@ViewScoped
public class CorrecaoCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5659861950428898387L;

	@Inject
	private Service<AlunoProva, Long> alunoProvaService;

	@Inject
	private GabaritoService gabaritoService;

	@Inject
	private AlunoService alunoService;
	private List<Aluno> alunos;

	@Inject
	private TurmaService turmaService;
	private Turma turma;
	private List<Turma> turmas;

	@Inject
	private ProvaService provaService;
	private Prova prova;
	private List<Prova> provas;

	@Inject
	private EscolaService escolaService;
	private Escola escola;
	private List<Escola> escolas;

	@Inject
	private PeriodoLetivoService periodoLetivoService;
	private PeriodoLetivo periodo;
	private List<PeriodoLetivo> periodos;

	private List<AlunoProva> alunoProvaList;

	public void listarEscolas() {
		escolas = escolaService.listar();
	}

	public void listarPeriodos() {
		periodos = periodoLetivoService.listar(escola);
	}

	public void listarTurmas() {
		turmas = turmaService.listar(periodo);
	}

	public void listarProvas() {
		provas = provaService.listar(/* turma */);
	}

	public void listarAlunos() {
		alunos = alunoService.listar(turma);
	}

	public void gerarMatriz() {
		alunoProvaList = alunoProvaService.listar();
	}

	//

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public List<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<AlunoProva> getAlunoProvaList() {
		return alunoProvaList;
	}

	public void setAlunoProvaList(
			List<AlunoProva> alunoProvaList) {
		this.alunoProvaList = alunoProvaList;
	}
	
	public long acertosPorQuestao(Questao questao) {
		return alunoProvaList.stream()
			.flatMap(a->a.getQuestoesAlternativas().stream())
			.filter(a -> a.getQuestaoProva().equals(questao) && a.getAlternativaProva().isResposta()).count();
	}
	
	public long acertosPorAluno(Aluno aluno) {
		return alunoProvaList.stream()
		.filter(ap->ap.getAluno().equals(aluno))
		.flatMap(a->a.getQuestoesAlternativas().stream())
			.filter(a -> a.getAlternativaProva().isResposta()).count();
	}
}
