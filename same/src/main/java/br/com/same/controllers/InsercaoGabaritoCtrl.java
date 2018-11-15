package br.com.same.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jsf.api.message.JsfMessage;

import br.com.same.jsf.FacesUtil;
import br.com.same.jsf.Msgs;
import br.com.same.models.Alternativa;
import br.com.same.models.Aluno;
import br.com.same.models.AlunoProva;
import br.com.same.models.AlunoProvaQuestaoAlternativa;
import br.com.same.models.Escola;
import br.com.same.models.PeriodoLetivo;
import br.com.same.models.Prova;
import br.com.same.models.Questao;
import br.com.same.models.Turma;
import br.com.same.services.AlunoGabaritoService;
import br.com.same.services.AlunoService;
import br.com.same.services.EscolaService;
import br.com.same.services.PeriodoLetivoService;
import br.com.same.services.ProvaService;
import br.com.same.services.TurmaService;

@Named
@ViewScoped
public class InsercaoGabaritoCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EscolaService escolaService;

	@Inject
	private ProvaService provaService;

	@Inject
	private PeriodoLetivoService periodoLetivoService;

	@Inject
	private TurmaService turmaService;

	@Inject
	private AlunoService alunoService;

	private List<AlunoProva> alunoProvas;

	@Inject
	private AlunoGabaritoService alunoGabaritoService;

	@Inject
	private JsfMessage<Msgs> msgs;

	@Inject
	private FacesUtil facesUtil;

	//

	public void salvar() {
		alunoGabaritoService.salvar(alunoProvas);
		msgs.addInfo().cadastradoComSucesso();
		facesUtil.atualizarComponente("msg");
		alunoProvas = new ArrayList<>();
	}

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

	private List<Prova> provas;

	private Prova prova;

	public void listarGabaritos() {
		provas = provaService.listar();
	}

	private List<Aluno> alunos;

	public void listarAlunos() {
		alunos = alunoService.listar(turma);
	}

	@PostConstruct
	public void init() {
		listarEscolas();
	}

	public void gerarGabarito() {
		listarAlunos();
		alunoProvas = alunoProvas(alunos, prova);
	}

	public List<AlunoProva> alunoProvas(List<Aluno> alunos, Prova prova) {
		List<AlunoProva> alunoGabaritos = new ArrayList<>();
		for (int i = 0; i < alunos.size(); i++) {
			Aluno aluno = alunos.get(i);

			AlunoProva alunoProva = new AlunoProva(aluno, prova);
			alunoGabaritos.add(alunoProva);
			for (int j = 0; j < prova.getQuestoes().size(); j++) {
				Questao questao = prova.getQuestoes().get(j);

				AlunoProvaQuestaoAlternativa questaoAlternativa = new AlunoProvaQuestaoAlternativa(alunoProva, questao, new Alternativa());
				alunoProva.getQuestoesAlternativas().add(questaoAlternativa);
			}
		}

		return alunoGabaritos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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

	public List<Prova> getProvass() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	public List<AlunoProva> getAlunoProvas() {
		return alunoProvas;
	}

	public void setAlunoProvas(List<AlunoProva> alunoProvas) {
		this.alunoProvas = alunoProvas;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

}
