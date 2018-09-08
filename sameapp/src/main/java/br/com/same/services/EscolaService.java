package br.com.same.services;

import java.io.Serializable;

import br.com.same.models.Escola;

public interface EscolaService extends Serializable {

	void cadastrar(Escola escola);

}
