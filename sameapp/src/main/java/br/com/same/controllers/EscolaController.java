package br.com.same.controllers;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.same.infra.jsf.FacesUtil;
import br.com.same.models.Escola;
import br.com.same.services.EscolaService;

@Named
public class EscolaController implements Serializable {

	private static final long serialVersionUID = 1123L;
	
	@Inject
	private EscolaService escolaService;
	
	@Inject
	private FacesUtil facesUtil;
	
	private Escola escola;
	
	public void cadastrar() {
		try {
			escolaService.cadastrar(escola);
		} catch(Exception e){
			
		}finally {
			facesUtil.updateComponent("msg");
		}
	}
}
