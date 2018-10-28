package br.com.same.services.impl;

import static java.util.Objects.isNull;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.AlunoProva;
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
	public void salvar(AlunoProva alunoGabarito) {
		alunoGabaritoRepository.save(alunoGabarito);
	}

	@Override
	public List<AlunoProva> listar() {
		return alunoGabaritoRepository.findAll();
	}

	@Override
	public AlunoProva buscarPorId(Long id) {
		return alunoGabaritoRepository.findBy(id);
	}

	@Override
	public void remover(AlunoProva alunoGabarito) {
		alunoGabaritoRepository.remove(alunoGabarito);
	}

	@Override
	public void editar(AlunoProva alunoGabarito) {
		alunoGabaritoRepository.save(alunoGabarito);
	}

	@Override
	public EntityRepository<AlunoProva, Long> getRepository() {
		return this.alunoGabaritoRepository;
	}

	@Override
	public void alterarStatus(AlunoProva alunoGabarito) {
		alunoGabarito.alterarStatus();
		this.editar(alunoGabarito);
	}

	@Override
	public void salvar(List<AlunoProva> alunoGabaritos) {
		if (isNull(alunoGabaritos))  throw new RuntimeException("A lista de alunos e gabaritos não pode ser nula!");
		alunoGabaritos.forEach(a->{
			System.out.println(a);
		});
		
		for (AlunoProva alunoProva : alunoGabaritos) {
			alunoGabaritoRepository.saveAndFlush(alunoProva);
		}
	}
}
