package br.com.same.controllers;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.cdi.Param;

import br.com.same.controllers.converters.EscolaConverter;
import br.com.same.jsf.FacesUtil;
import br.com.same.jsf.Msgs;
import br.com.same.jsf.primefaces.LazyDataModel;
import br.com.same.models.Escola;
import br.com.same.models.PeriodoLetivo;
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

	private PeriodoLetivo periodoLetivo;

	private LazyDataModel<Escola, Long> escolas;
	
	private List<Escola> escolasList;

	@Inject
	private JsfMessage<Msgs> msgs;

	@Inject
	private EscolaService escolaService;

	@Inject
	private FacesUtil facesUtil;
	
	public void alterarStatus() {
		escolaService.alterarStatus(escola);
		msgs.addInfo().statusAlteradoSucesso();
		facesUtil.atualizarComponente("msgs");
	}

	public String salvar() {
		escolaService.salvar(escola);
		msgs.addInfo().cadastradoComSucesso();
		escola = null;
		facesUtil.atualizarComponente("msgs");
		return null;
	}

	public String editar() {
		escolaService.editar(escola);
		msgs.addInfo().editadoComSucesso();
		escola = null;
		facesUtil.atualizarComponente("msgs");
		return "/private/escola/list.xhtml?faces-redirect=true";
	}

	public void listar() {
		if (facesUtil.isNotPostback() || isNull(escolas)) {
			this.escolas = new LazyDataModel<>(escolaService.getRepository());
		}
	}

	public Escola getEscola() {
		if (isNull(escola))
			escola = new Escola();
		return escola;
	}
	
	public List<Escola> getEscolasList() {
		if(isNull(this.escolasList)) escolasList = escolaService.listar();
		return escolasList;
	}

	public void setEscolasList(List<Escola> escolasList) {
		this.escolasList = escolasList;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public LazyDataModel<Escola, Long> getEscolas() {
		return escolas;
	}

	public void setEscolas(LazyDataModel<Escola, Long> escolas) {
		this.escolas = escolas;
	}

	public boolean isEditando() {
		return nonNull(getEscola()) && nonNull(getEscola().getId());
	}

	public PeriodoLetivo getPeriodoLetivo() {
		if (Objects.isNull(periodoLetivo))
			periodoLetivo = new PeriodoLetivo();
		return periodoLetivo;
	}

	public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public void adicionar() {
		this.escola.adicionar(periodoLetivo);
		msgs.addInfo().cadastradoComSucesso();
		facesUtil.atualizarComponente("msgs");
		periodoLetivo = new PeriodoLetivo();
	}

	public void atualizar() {
		this.escola.atualizar(periodoLetivo);
		msgs.addInfo().editadoComSucesso();
		facesUtil.atualizarComponente("msgs");
		periodoLetivo = new PeriodoLetivo();
	}

	public void remover() {
		this.escola.remover(periodoLetivo);
		msgs.addInfo().deletadoComSucesso();
		facesUtil.atualizarComponente("msgs");
		periodoLetivo = new PeriodoLetivo();
	}
}
