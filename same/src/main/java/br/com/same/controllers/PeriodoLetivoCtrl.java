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

import br.com.same.controllers.converters.PeriodoLetivoConverter;
import br.com.same.jsf.Msgs;
import br.com.same.models.PeriodoLetivo;
import br.com.same.services.PeriodoLetivoService;

@Named
@ViewScoped
public class PeriodoLetivoCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	@Param(name = "periodoLetivo", converterClass = PeriodoLetivoConverter.class)
	private PeriodoLetivo periodoLetivo;

	private List<PeriodoLetivo> periodoLetivos;

	@Inject
	private JsfMessage<Msgs> msgs;

	@Inject
	private PeriodoLetivoService periodoLetivoService;

	public String salvar() {
		periodoLetivoService.salvar(periodoLetivo);
		msgs.addInfo().cadastradoComSucesso();
		periodoLetivo = null;
		PrimeFaces.current().ajax().update("msgs");
		return null;
	}

	public String editar() {
		periodoLetivoService.editar(periodoLetivo);
		msgs.addInfo().editadoComSucesso();
		periodoLetivo = null;
		PrimeFaces.current().ajax().update("msgs");
		return "/private/periodoLetivo/list.xhtml?faces-redirect=true";
	}

	public void listarPeriodoLetivos() {
		this.periodoLetivos = periodoLetivoService.listar();
	}

	public PeriodoLetivo getPeriodoLetivo() {
		if (Objects.isNull(periodoLetivo))
			periodoLetivo = new PeriodoLetivo();
		return periodoLetivo;
	}

	public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public List<PeriodoLetivo> getPeriodoLetivos() {
		return periodoLetivos;
	}

	public void setPeriodoLetivos(List<PeriodoLetivo> periodoLetivos) {
		this.periodoLetivos = periodoLetivos;
	}

	public boolean isEditando() {
		return nonNull(periodoLetivo) && nonNull(periodoLetivo.getId());
	}
}
