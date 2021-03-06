package br.com.same.controllers;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.cdi.Param;

import br.com.same.controllers.converters.TurmaConverter;
import br.com.same.jsf.FacesUtil;
import br.com.same.jsf.Msgs;
import br.com.same.jsf.primefaces.LazyDataModel;
import br.com.same.models.Turma;
import br.com.same.services.TurmaService;

@Named
@ViewScoped
public class TurmaCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	@Param(name = "turma", converterClass = TurmaConverter.class)
	private Turma turma;

	private LazyDataModel<Turma, Long> turmas;

	@Inject
	private JsfMessage<Msgs> msgs;

	@Inject
	private TurmaService turmaService;

	@Inject
	private FacesUtil facesUtil;

	public void alterarStatus() {
		turmaService.alterarStatus(turma);
		msgs.addInfo().statusAlteradoSucesso();
		facesUtil.atualizarComponente("msgs");
	}
	
	public String salvar() {
		turmaService.salvar(turma);
		msgs.addInfo().cadastradoComSucesso();
		turma = null;
		facesUtil.atualizarComponente("msgs");
		return null;
	}

	public String editar() {
		turmaService.editar(turma);
		msgs.addInfo().editadoComSucesso();
		turma = null;
		facesUtil.atualizarComponente("msgs");
		return "/private/turma/list.xhtml?faces-redirect=true";
	}

	public void listar() {
		if (facesUtil.isNotPostback() || isNull(turmas)) {
			this.turmas = new LazyDataModel<>(turmaService.getRepository());
		}
	}

	public Turma getTurma() {
		if (isNull(turma))
			turma = new Turma();
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public LazyDataModel<Turma, Long> getTurmas() {
		return turmas;
	}

	public void setTurmas(LazyDataModel<Turma, Long> turmas) {
		this.turmas = turmas;
	}

	public boolean isEditando() {
		return nonNull(getTurma()) && nonNull(getTurma().getId());
	}

}
