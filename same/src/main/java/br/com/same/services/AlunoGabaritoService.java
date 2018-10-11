package br.com.same.services;

import java.util.List;

import br.com.same.models.AlunoGabarito;

public interface AlunoGabaritoService extends Service<AlunoGabarito, Long>{

	void salvar(List<AlunoGabarito> alunoGabaritos);

}
