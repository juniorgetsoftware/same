package br.com.same.controllers;

import java.util.Objects;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.primefaces.PrimeFaces;

import br.com.same.jsf.Msgs;
import br.com.same.models.Escola;
import br.com.same.services.EscolaService;

@Named
@RequestScoped
public class EscolaCtrl {
	
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

	private Escola escola;

	public Escola getEscola() {
		if (Objects.isNull(escola))  escola = new Escola();
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
}
