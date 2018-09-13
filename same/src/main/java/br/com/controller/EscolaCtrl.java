package br.com.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.models.Escola;
import br.com.service.EscolaService;
import br.com.service.Impl;

@Named
@ViewScoped
public class EscolaCtrl implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Escola escola = new Escola();
	
	@Inject @Impl
	private EscolaService escolaService;
	
	public void salvar() {
		escolaService.salvar(escola);
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
	

}
