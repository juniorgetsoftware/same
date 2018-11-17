package br.com.same.controllers;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.cdi.Param;

import br.com.same.controllers.converters.ProvaConverter;
import br.com.same.jsf.FacesUtil;
import br.com.same.jsf.Msgs;
import br.com.same.jsf.primefaces.LazyDataModel;
import br.com.same.models.Escola;
import br.com.same.models.Gabarito;
import br.com.same.models.PeriodoLetivo;
import br.com.same.models.Prova;
import br.com.same.models.Turma;
import br.com.same.services.EscolaService;
import br.com.same.services.GabaritoService;
import br.com.same.services.PeriodoLetivoService;
import br.com.same.services.ProvaService;
import br.com.same.services.TurmaService;

@Named
@ViewScoped
public class ProvaCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EscolaService escolaService;
	private Escola escola;
	private List<Escola> escolas;

	public void listarEscolas() {
		escolas = escolaService.listar();
	}

	@Inject
	private PeriodoLetivoService periodoLetivoService;
	private PeriodoLetivo periodo;
	private List<PeriodoLetivo> periodos;

	public void listarPeriodos() {
		periodos = periodoLetivoService.listar(escola);
	}

	@Inject
	private TurmaService turmaService;
	private List<Turma> turmas;

	public void listarTurmas() {
		turmas = turmaService.listar(periodo);
	}

	@Min(value = 2, message = "O gabarito deve ter pelo menos 5 questões")
	private int quantidadeQuestoes;
	@Min(value = 2, message = "A questão deve ter pelo menos 2 alternativa")
	private int quantidadeAlternativasPorQuestao;

	@Inject
	@Param(name = "prova", converterClass = ProvaConverter.class)
	private Prova prova;

	private LazyDataModel<Prova, Long> provas;

	@Inject
	private JsfMessage<Msgs> msgs;

	@Inject
	private ProvaService provaService;

	@Inject
	private FacesUtil facesUtil;

	@Inject
	private GabaritoService gabaritoService;

	public void alterarStatus() {
		provaService.alterarStatus(prova);
		msgs.addInfo().statusAlteradoSucesso();
		facesUtil.atualizarComponente("msgs");
	}

	public String salvar() {
		Gabarito gabarito = prova.gerarGabarito();
		provaService.salvar(prova);

		gabaritoService.salvar(gabarito);
		msgs.addInfo().cadastradoComSucesso();
		prova = null;
		facesUtil.atualizarComponente("msgs");
		return null;
	}

	public String editar() {
		provaService.editar(prova);
		msgs.addInfo().editadoComSucesso();
		prova = null;
		facesUtil.atualizarComponente("msgs");
		return "/private/prova/list.xhtml?faces-redirect=true";
	}

	public void listar() {
		if (facesUtil.isNotPostback() || isNull(provas)) {
			this.provas = new LazyDataModel<>(provaService.getRepository());
		}
	}

	public void gerarCamposProva() {
		this.getProva().gerarCamposDaProva(quantidadeQuestoes, quantidadeAlternativasPorQuestao);
	}

	//

	public Prova getProva() {
		if (isNull(prova))
			prova = new Prova();
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public int getQuantidadeQuestoes() {
		return quantidadeQuestoes;
	}

	public void setQuantidadeQuestoes(int quantidadeQuestoes) {
		this.quantidadeQuestoes = quantidadeQuestoes;
	}

	public int getQuantidadeAlternativasPorQuestao() {
		return quantidadeAlternativasPorQuestao;
	}

	public void setQuantidadeAlternativasPorQuestao(int quantidadeAlternativasPorQuestao) {
		this.quantidadeAlternativasPorQuestao = quantidadeAlternativasPorQuestao;
	}

	public LazyDataModel<Prova, Long> getProvas() {
		return provas;
	}

	public void setProvas(LazyDataModel<Prova, Long> provas) {
		this.provas = provas;
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

	public List<Escola> getEscolas() {
		return escolas;
	}

	public List<PeriodoLetivo> getPeriodos() {
		return periodos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

}
