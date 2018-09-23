package br.com.same.controllers;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.cdi.Param;

import br.com.same.controllers.converters.ProfessorConverter;
import br.com.same.jsf.FacesUtil;
import br.com.same.jsf.Msgs;
import br.com.same.jsf.primefaces.LazyDataModel;
import br.com.same.models.Professor;
import br.com.same.services.ProfessorService;

@Named
@ViewScoped
public class ProfessorCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	@Param(name = "professor", converterClass = ProfessorConverter.class)
	private Professor professor;

	private LazyDataModel<Professor, Long> professores;

	@Inject
	private JsfMessage<Msgs> msgs;

	@Inject
	private ProfessorService professorService;

	@Inject
	private FacesUtil facesUtil;

	public String salvar() {
		professorService.salvar(professor);
		msgs.addInfo().cadastradoComSucesso();
		professor = null;
		facesUtil.atualizarComponente("msgs");
		return null;
	}

	public String editar() {
		professorService.editar(professor);
		msgs.addInfo().editadoComSucesso();
		professor = null;
		facesUtil.atualizarComponente("msgs");
		return "/private/professor/list.xhtml?faces-redirect=true";
	}

	public void listar() {
		if (facesUtil.isNotPostback() || isNull(professores)) {
			this.professores = new LazyDataModel<>(professorService.getRepository());
		}
	}

	public Professor getProfessor() {
		if (isNull(professor))
			professor = new Professor();
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public LazyDataModel<Professor, Long> getProfessores() {
		return professores;
	}

	public void setProfessores(LazyDataModel<Professor, Long> professores) {
		this.professores = professores;
	}

	public boolean isEditando() {
		return nonNull(getProfessor()) && nonNull(getProfessor().getId());
	}

}
