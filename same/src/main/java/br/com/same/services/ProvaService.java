package br.com.same.services;

import java.util.List;

import br.com.same.models.Prova;
import br.com.same.models.Turma;

public interface ProvaService extends Service<Prova, Long> {

	List<Prova> listar(Turma turma);

}
