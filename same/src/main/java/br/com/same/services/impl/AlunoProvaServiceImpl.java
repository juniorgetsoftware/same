package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.AlunoProva;
import br.com.same.models.Prova;
import br.com.same.repository.AlunoProvaRepository;
import br.com.same.services.AlunoProvaService;

public class AlunoProvaServiceImpl implements AlunoProvaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoProvaRepository alunoProvaRepository;

	@Override
	public void salvar(AlunoProva t) {
		alunoProvaRepository.save(t);
	}

	@Override
	public void editar(AlunoProva t) {
		alunoProvaRepository.save(t);
	}

	@Override
	public List<AlunoProva> listar() {
		return alunoProvaRepository.findAll();
	}

	@Override
	public AlunoProva buscarPorId(Long id) {
		return alunoProvaRepository.findBy(id);
	}

	@Override
	public void remover(AlunoProva t) {
		alunoProvaRepository.remove(t);
	}

	@Override
	public EntityRepository<AlunoProva, Long> getRepository() {
		return alunoProvaRepository;
	}

	@Override
	public void alterarStatus(AlunoProva t) {
		t.alterarStatus();
		this.editar(t);
	}

	@Override
	public List<AlunoProva> listar(Prova prova) {
		return alunoProvaRepository.findByProva(prova);
	}

}
