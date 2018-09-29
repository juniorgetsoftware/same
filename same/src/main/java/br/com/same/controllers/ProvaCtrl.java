package br.com.same.controllers;

import static java.util.Objects.isNull;

import java.io.Serializable;

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
import br.com.same.models.Gabarito;
import br.com.same.models.Prova;
import br.com.same.services.ProvaService;
import br.com.same.services.Service;

@Named
@ViewScoped
public class ProvaCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Min(value = 5, message = "O gabarito deve ter pelo menos 5 questões")
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
	private Service<Gabarito, Long> gabaritoService;

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
}
