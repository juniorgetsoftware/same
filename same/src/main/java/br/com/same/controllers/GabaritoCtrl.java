package br.com.same.controllers;

import static java.util.Objects.isNull;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.cdi.Param;

import br.com.same.controllers.converters.GabaritoConverter;
import br.com.same.jsf.FacesUtil;
import br.com.same.jsf.Msgs;
import br.com.same.jsf.primefaces.LazyDataModel;
import br.com.same.models.Gabarito;
import br.com.same.services.GabaritoService;

@Named
@ViewScoped
public class GabaritoCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Min(value = 5, message = "O gabarito deve ter pelo menos 5 questões")
	private int quantidadeQuestoes;
	@Min(value = 2, message = "A questão deve ter pelo menos 2 alternativa")
	private int quantidadeAlternativasPorQuestao;

	@Inject
	@Param(name = "gabarito", converterClass = GabaritoConverter.class)
	private Gabarito gabarito;

	private LazyDataModel<Gabarito, Long> gabaritos;

	@Inject
	private JsfMessage<Msgs> msgs;

	@Inject
	private GabaritoService gabaritoService;

	@Inject
	private FacesUtil facesUtil;
	
	public void alterarStatus() {
		gabaritoService.alterarStatus(gabarito);
		msgs.addInfo().statusAlteradoSucesso();
		facesUtil.atualizarComponente("msgs");
	}

	public String salvar() {
		gabaritoService.salvar(gabarito);
		msgs.addInfo().cadastradoComSucesso();
		gabarito = null;
		facesUtil.atualizarComponente("msgs");
		return null;
	}

	public String editar() {
		gabaritoService.editar(gabarito);
		msgs.addInfo().editadoComSucesso();
		gabarito = null;
		facesUtil.atualizarComponente("msgs");
		return "/private/gabarito/list.xhtml?faces-redirect=true";
	}

	public void listar() {
		if (facesUtil.isNotPostback() || isNull(gabaritos)) {
			this.gabaritos = new LazyDataModel<>(gabaritoService.getRepository());
		}
	}

	public void gerarCamposGabarito() {
		this.getGabarito().gerarCamposDoGabarito(quantidadeQuestoes, quantidadeAlternativasPorQuestao);
	}

	//

	public Gabarito getGabarito() {
		if (isNull(gabarito))
			gabarito = new Gabarito();
		return gabarito;
	}

	public void setGabarito(Gabarito gabarito) {
		this.gabarito = gabarito;
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

	public LazyDataModel<Gabarito, Long> getGabaritos() {
		return gabaritos;
	}

	public void setGabaritos(LazyDataModel<Gabarito, Long> gabaritos) {
		this.gabaritos = gabaritos;
	}
}
