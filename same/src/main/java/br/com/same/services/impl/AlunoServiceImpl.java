package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Aluno;
import br.com.same.models.Turma;
import br.com.same.repository.AlunoRepository;
import br.com.same.services.AlunoService;

public class AlunoServiceImpl implements AlunoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoRepository alunoRepository;

	@Override
	public void salvar(Aluno aluno) {
		alunoRepository.save(aluno);
	}

	@Override
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno buscarPorId(Long id) {
		return alunoRepository.findBy(id);
	}

	@Override
	public void remover(Aluno aluno) {
		alunoRepository.remove(aluno);
	}

	@Override
	public void editar(Aluno aluno) {
		alunoRepository.save(aluno);
	}

	@Override
	public EntityRepository<Aluno, Long> getRepository() {
		return this.alunoRepository;
	}

	@Override
	public List<Aluno> listar(Turma turma) {
		return alunoRepository.findByTurmaOrderByNome(turma);
	}

}
