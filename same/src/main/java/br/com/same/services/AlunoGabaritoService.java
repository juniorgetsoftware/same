package br.com.same.services;

import java.util.List;

import br.com.same.models.AlunoProva;

public interface AlunoGabaritoService extends Service<AlunoProva, Long>{

	void salvar(List<AlunoProva> alunoGabaritos);

}
