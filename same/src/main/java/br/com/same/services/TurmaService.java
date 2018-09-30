package br.com.same.services;

import java.util.List;

import br.com.same.models.PeriodoLetivo;
import br.com.same.models.Turma;

public interface TurmaService extends Service<Turma, Long> {

	List<Turma> listar(PeriodoLetivo periodo);

}
