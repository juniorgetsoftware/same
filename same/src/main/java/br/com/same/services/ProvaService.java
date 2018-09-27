package br.com.same.services;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Prova;

public interface ProvaService extends Service<Prova, Long> {

	void salvar(Prova prova);

	void editar(Prova prova);

	List<Prova> listar();

	Prova buscarPorId(Long id);

	void remover(Prova prova);

	EntityRepository<Prova, Long> getRepository();

}
