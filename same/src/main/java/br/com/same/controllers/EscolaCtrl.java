package br.com.same.controllers;

import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.cdi.Param;
import org.primefaces.PrimeFaces;

import br.com.same.controllers.converters.EscolaConverter;
import br.com.same.jsf.Msgs;
import br.com.same.models.Escola;
import br.com.same.services.EscolaService;

@Named
@ViewScoped
public class EscolaCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	@Param(name = "escola", converterClass = EscolaConverter.class)
	private Escola escola;

	private List<Escola> escolas;

	@Inject
	private JsfMessage<Msgs> msgs;

	@Inject
	private EscolaService escolaService;

	public String salvar() {
		escolaService.salvar(escola);
		msgs.addInfo().cadastradoComSucesso();
		escola = null;
		PrimeFaces.current().ajax().update("msgs");
		return null;
	}

	public String editar() {
		escolaService.editar(escola);
		msgs.addInfo().editadoComSucesso();
		escola = null;
		PrimeFaces.current().ajax().update("msgs");
		return "/private/escola/list.xhtml?faces-redirect=true";
	}

	public void listarEscolas() {
		this.escolas = escolaService.listar();
	}

	public Escola getEscola() {
		if (Objects.isNull(escola))
			escola = new Escola();
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

	public boolean isEditando() {
		return nonNull(escola) && nonNull(escola.getId());
	}
}
