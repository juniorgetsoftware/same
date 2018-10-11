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
import br.com.same.models.Aluno;
import br.com.same.models.AlunoGabarito;
import br.com.same.models.Escola;
import br.com.same.models.Gabarito;
import br.com.same.models.PeriodoLetivo;
import br.com.same.models.Turma;
import br.com.same.services.AlunoGabaritoService;
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
	
	private List<AlunoGabarito> alunoGabaritos;

	@Inject
	private AlunoGabaritoService alunoGabaritoService;
	
	@Inject
	private JsfMessage<Msgs> msgs;
	
	@Inject
	private FacesUtil facesUtil;
	
	//
	
	public void salvar() {
		alunoGabaritoService.salvar(alunoGabaritos);
		msgs.addInfo().cadastradoComSucesso();
		facesUtil.atualizarComponente("msg");
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

	private List<Gabarito> gabaritos;
	private Gabarito gabarito;

	public void listarGabaritos() {
		gabaritos = gabaritoService.listar(/*turma*/);
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
		alunoGabaritos = alunoGabaritos(alunos, gabarito);
	}

	public List<AlunoGabarito> alunoGabaritos(List<Aluno> list, Gabarito gabarito) {
		List<AlunoGabarito> alunoGabaritos = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			alunoGabaritos.add(new AlunoGabarito(list.get(i), gabarito));
		}
		return alunoGabaritos;
	}


	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

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
}
