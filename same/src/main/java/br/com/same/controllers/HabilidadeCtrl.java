package br.com.same.controllers;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.cdi.Param;

import br.com.same.controllers.converters.HabilidadeConverter;
import br.com.same.jsf.FacesUtil;
import br.com.same.jsf.Msgs;
import br.com.same.jsf.primefaces.LazyDataModel;
import br.com.same.models.Habilidade;
import br.com.same.services.HabilidadeService;

@Named
@ViewScoped
public class HabilidadeCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	@Param(name = "habilidade", converterClass = HabilidadeConverter.class)
	private Habilidade habilidade;

	private LazyDataModel<Habilidade, Long> habilidades;

	@Inject
	private JsfMessage<Msgs> msgs;
	
	private List<Habilidade> habilidadesList;

	@Inject
	private HabilidadeService habilidadeService;

	@Inject
	private FacesUtil facesUtil;

	public String salvar() {
		habilidadeService.salvar(habilidade);
		msgs.addInfo().cadastradoComSucesso();
		habilidade = null;
		facesUtil.atualizarComponente("msgs");
		return null;
	}

	public void alterarStatus() {
		habilidadeService.alterarStatus(habilidade);
		msgs.addInfo().statusAlteradoSucesso();
		facesUtil.atualizarComponente("msgs");
	}
	
	public String editar() {
		habilidadeService.editar(habilidade);
		msgs.addInfo().editadoComSucesso();
		habilidade = null;
		facesUtil.atualizarComponente("msgs");
		return "/private/habilidade/list.xhtml?faces-redirect=true";
	}

	public void listar() {
		if (facesUtil.isNotPostback() || isNull(habilidades)) {
			this.habilidades = new LazyDataModel<>(habilidadeService.getRepository());
		}
	}

	public void listarHabilidades() {
		if (facesUtil.isNotPostback() || isNull(habilidadesList)) {
			this.habilidadesList = habilidadeService.listar();
		}
	}

	public Habilidade getHabilidade() {
		if (isNull(habilidade))
			habilidade = new Habilidade();
		return habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}

	public LazyDataModel<Habilidade, Long> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(LazyDataModel<Habilidade, Long> habilidades) {
		this.habilidades = habilidades;
	}

	public boolean isEditando() {
		return nonNull(getHabilidade()) && nonNull(getHabilidade().getId());
	}

	public List<Habilidade> getHabilidadesList() {
		return habilidadesList;
	}

	public void setHabilidadesList(List<Habilidade> habilidadesList) {
		this.habilidadesList = habilidadesList;
	}

}
