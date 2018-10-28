package br.com.same.services;

import java.util.List;

import br.com.same.models.Gabarito;
import br.com.same.models.Turma;

public interface GabaritoService extends Service<Gabarito, Long> {

	List<Gabarito> listar(Turma turma);

	void salvar(List<Gabarito> gabaritos);

}
