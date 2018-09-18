package br.com.same.services;

import java.util.List;

import br.com.same.models.Escola;

public interface EscolaService {
	
	void salvar(Escola escola);

	List<Escola> listar();

}
