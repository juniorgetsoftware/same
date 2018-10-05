package br.com.same.controllers;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.cdi.Param;

import br.com.same.controllers.converters.AlunoConverter;
import br.com.same.jsf.FacesUtil;
import br.com.same.jsf.Msgs;
import br.com.same.jsf.primefaces.LazyDataModel;
import br.com.same.models.Aluno;
import br.com.same.services.AlunoService;

@Named
@ViewScoped
public class AlunoCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	@Param(name = "aluno", converterClass = AlunoConverter.class)
	private Aluno aluno;

	private LazyDataModel<Aluno, Long> alunos;

	@Inject
	private JsfMessage<Msgs> msgs;

	@Inject
	private AlunoService alunoService;

	@Inject
	private FacesUtil facesUtil;

	public String salvar() {
		alunoService.salvar(aluno);
		msgs.addInfo().cadastradoComSucesso();
		aluno = null;
		facesUtil.atualizarComponente("msgs");
		return null;
	}

	public void alterarStatus() {
		alunoService.alterarStatus(aluno);
		msgs.addInfo().statusAlteradoSucesso();
		facesUtil.atualizarComponente("msgs");
	}
	
	public String editar() {
		alunoService.editar(aluno);
		msgs.addInfo().editadoComSucesso();
		aluno = null;
		facesUtil.atualizarComponente("msgs");
		return "/private/aluno/list.xhtml?faces-redirect=true";
	}

	public void listar() {
		if (facesUtil.isNotPostback() || isNull(alunos)) {
			this.alunos = new LazyDataModel<>(alunoService.getRepository());
		}
	}

	public Aluno getAluno() {
		if (isNull(aluno))
			aluno = new Aluno();
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public LazyDataModel<Aluno, Long> getAlunos() {
		return alunos;
	}

	public void setAlunos(LazyDataModel<Aluno, Long> alunos) {
		this.alunos = alunos;
	}

	public boolean isEditando() {
		return nonNull(getAluno()) && nonNull(getAluno().getId());
	}

}
