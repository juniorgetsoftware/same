package br.com.same.controllers;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.Objects;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.cdi.Param;

import br.com.same.controllers.converters.PeriodoLetivoConverter;
import br.com.same.jsf.FacesUtil;
import br.com.same.jsf.Msgs;
import br.com.same.jsf.primefaces.LazyDataModel;
import br.com.same.models.PeriodoLetivo;
import br.com.same.models.Turma;
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

	private LazyDataModel<PeriodoLetivo, Long> periodoLetivos;

	@Inject
	private JsfMessage<Msgs> msgs;

	@Inject
	private PeriodoLetivoService periodoLetivoService;

	@Inject
	private FacesUtil facesUtil;

	private Turma turma;

	public String salvar() {
		periodoLetivoService.salvar(periodoLetivo);
		msgs.addInfo().cadastradoComSucesso();
		periodoLetivo = null;
		facesUtil.atualizarComponente("msgs");
		return null;
	}

	public String editar() {
		periodoLetivoService.editar(periodoLetivo);
		msgs.addInfo().editadoComSucesso();
		periodoLetivo = null;
		facesUtil.atualizarComponente("msgs");
		return "/private/periodoLetivo/list.xhtml?faces-redirect=true";
	}

	public void listar() {
		if (facesUtil.isNotPostback() || isNull(periodoLetivos)) {
			this.periodoLetivos = new LazyDataModel<>(periodoLetivoService.getRepository());
		}
	}

	public PeriodoLetivo getPeriodoLetivo() {
		if (Objects.isNull(periodoLetivo))
			periodoLetivo = new PeriodoLetivo();
		return periodoLetivo;
	}

	public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public LazyDataModel<PeriodoLetivo, Long> getPeriodoLetivos() {
		return periodoLetivos;
	}

	public void setPeriodoLetivos(LazyDataModel<PeriodoLetivo, Long> periodoLetivos) {
		this.periodoLetivos = periodoLetivos;
	}

	public boolean isEditando() {
		return nonNull(periodoLetivo) && nonNull(periodoLetivo.getId());
	}

	public void adicionar() {
		this.periodoLetivo.adicionar(turma);
		msgs.addInfo().cadastradoComSucesso();
		facesUtil.atualizarComponente("msgs");
		turma = new Turma();
	}

	public void atualizar() {
		this.periodoLetivo.atualizar(turma);
		msgs.addInfo().editadoComSucesso();
		facesUtil.atualizarComponente("msgs");
		turma = new Turma();
	}

	public void remover() {
		this.periodoLetivo.remover(turma);
		msgs.addInfo().deletadoComSucesso();
		facesUtil.atualizarComponente("msgs");
		turma = new Turma();
	}
}
