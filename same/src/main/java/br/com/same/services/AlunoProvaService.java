package br.com.same.services;

import java.util.List;

import br.com.same.models.AlunoProva;
import br.com.same.models.Prova;

public interface AlunoProvaService extends Service<AlunoProva, Long> {

	List<AlunoProva> listar(Prova prova);
	
}
