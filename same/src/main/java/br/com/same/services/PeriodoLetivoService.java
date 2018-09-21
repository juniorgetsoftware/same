package br.com.same.services;

import java.io.Serializable;
import java.util.List;

import br.com.same.models.PeriodoLetivo;

public interface PeriodoLetivoService extends Serializable {

	PeriodoLetivo buscarPorId(Long long1);

	void salvar(PeriodoLetivo periodoLetivo);

	void editar(PeriodoLetivo periodoLetivo);

	List<PeriodoLetivo> listar();

	void remover(PeriodoLetivo periodoLetivo);

}
