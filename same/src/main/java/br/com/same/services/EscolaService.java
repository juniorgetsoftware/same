package br.com.same.services;

import java.io.Serializable;
import java.util.List;

import br.com.same.models.Escola;

public interface EscolaService extends Serializable {

	void salvar(Escola escola);

	void editar(Escola escola);

	List<Escola> listar();

	Escola buscarPorId(Long id);

	void remover(Escola escola);

}
