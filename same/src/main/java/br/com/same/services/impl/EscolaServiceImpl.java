package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Escola;
import br.com.same.repository.EscolaRepository;
import br.com.same.services.EscolaService;

public class EscolaServiceImpl implements EscolaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EscolaRepository escolaRepository;

	@Override
	public void salvar(Escola escola) {
		escolaRepository.save(escola);
	}

	@Override
	public List<Escola> listar() {
		return escolaRepository.findAll();
	}

	@Override
	public Escola buscarPorId(Long id) {
		return escolaRepository.findBy(id);
	}

	@Override
	public void remover(Escola escola) {
		escolaRepository.remove(escola);
	}

	@Override
	public void editar(Escola escola) {
		escolaRepository.save(escola);
	}

	@Override
	public EntityRepository<Escola, Long> getRepository() {
		return this.escolaRepository;
	}

	@Override
	public void alterarStatus(Escola escola) {
		escola.alterarStatus();
		this.editar(escola);
	}
}
