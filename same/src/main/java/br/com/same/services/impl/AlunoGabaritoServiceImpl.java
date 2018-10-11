package br.com.same.services.impl;

import static java.util.Objects.isNull;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.AlunoGabarito;
import br.com.same.repository.AlunoGabaritoRepository;
import br.com.same.services.AlunoGabaritoService;

public class AlunoGabaritoServiceImpl implements AlunoGabaritoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoGabaritoRepository alunoGabaritoRepository;

	@Override
	public void salvar(AlunoGabarito alunoGabarito) {
		alunoGabaritoRepository.save(alunoGabarito);
	}

	@Override
	public List<AlunoGabarito> listar() {
		return alunoGabaritoRepository.findAll();
	}

	@Override
	public AlunoGabarito buscarPorId(Long id) {
		return alunoGabaritoRepository.findBy(id);
	}

	@Override
	public void remover(AlunoGabarito alunoGabarito) {
		alunoGabaritoRepository.remove(alunoGabarito);
	}

	@Override
	public void editar(AlunoGabarito alunoGabarito) {
		alunoGabaritoRepository.save(alunoGabarito);
	}

	@Override
	public EntityRepository<AlunoGabarito, Long> getRepository() {
		return this.alunoGabaritoRepository;
	}

	@Override
	public void alterarStatus(AlunoGabarito alunoGabarito) {
		alunoGabarito.alterarStatus();
		this.editar(alunoGabarito);
	}

	@Override
	public void salvar(List<AlunoGabarito> alunoGabaritos) {
		if (isNull(alunoGabaritos))  throw new RuntimeException("A lista de alunos e gabaritos não pode ser nula!");
		alunoGabaritos.forEach(a -> this.salvar(a));
	}
}
