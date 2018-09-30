package br.com.same.services;

import java.util.List;

import br.com.same.models.Escola;
import br.com.same.models.PeriodoLetivo;

public interface PeriodoLetivoService extends Service<PeriodoLetivo, Long> {

	List<PeriodoLetivo> listar(Escola escola);

}
