package br.com.same.controllers;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.cdi.Param;

import br.com.same.controllers.converters.DisciplinaConverter;
import br.com.same.jsf.FacesUtil;
import br.com.same.jsf.Msgs;
import br.com.same.jsf.primefaces.LazyDataModel;
import br.com.same.models.Disciplina;
import br.com.same.services.DisciplinaService;

@Named
@ViewScoped
public class DisciplinaCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	@Param(name = "disciplina", converterClass = DisciplinaConverter.class)
	private Disciplina disciplina;

	private LazyDataModel<Disciplina, Long> disciplinas;

	@Inject
	private JsfMessage<Msgs> msgs;

	@Inject
	private DisciplinaService disciplinaService;

	@Inject
	private FacesUtil facesUtil;

	public String salvar() {
		disciplinaService.salvar(disciplina);
		msgs.addInfo().cadastradoComSucesso();
		disciplina = null;
		facesUtil.atualizarComponente("msgs");
		return null;
	}

	public String editar() {
		disciplinaService.editar(disciplina);
		msgs.addInfo().editadoComSucesso();
		disciplina = null;
		facesUtil.atualizarComponente("msgs");
		return "/private/disciplina/list.xhtml?faces-redirect=true";
	}

	public void listar() {
		if (facesUtil.isNotPostback() || isNull(disciplinas)) {
			this.disciplinas = new LazyDataModel<>(disciplinaService.getRepository());
		}
	}

	public Disciplina getDisciplina() {
		if (isNull(disciplina))
			disciplina = new Disciplina();
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public LazyDataModel<Disciplina, Long> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(LazyDataModel<Disciplina, Long> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public boolean isEditando() {
		return nonNull(getDisciplina()) && nonNull(getDisciplina().getId());
	}

}
