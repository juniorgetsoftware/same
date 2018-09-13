package br.com.service;

import java.io.Serializable;

import br.com.models.Escola;

public interface EscolaService extends Serializable {

	void salvar(Escola escola);

}
