package br.com.same.controllers;

import java.io.Serializable;
import java.util.Objects;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.same.infra.jsf.FacesUtil;
import br.com.same.infra.jsf.MessagesHelper;
import br.com.same.models.Escola;
import br.com.same.services.EscolaService;

@Named
@ViewScoped
public class EscolaController implements Serializable {

	private static final long serialVersionUID = 1123L;

	@Inject
	private EscolaService escolaService;

	@Inject
	private MessagesHelper helper;

	@Inject
	private FacesUtil facesUtil;

	private Escola escola;

	public void cadastrar() {
		try {
			escolaService.cadastrar(escola);
			helper.addInfoMessage("msgs", "Escola dacastrada com sucesso.", "");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			facesUtil.updateComponent("msgs");
			escola = null;
		}
	}

	public Escola getEscola() {
		if (Objects.isNull(escola))
			escola = new Escola();
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
}
