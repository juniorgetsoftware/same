package br.com.same.services;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Aluno;

public interface AlunoService extends Service<Aluno, Long> {

	void salvar(Aluno professor);

	void editar(Aluno professor);

	List<Aluno> listar();

	Aluno buscarPorId(Long id);

	void remover(Aluno professor);

	EntityRepository<Aluno, Long> getRepository();

}
