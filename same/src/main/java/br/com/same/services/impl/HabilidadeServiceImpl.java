package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Habilidade;
import br.com.same.repository.HabilidadeRepository;
import br.com.same.services.HabilidadeService;

public class HabilidadeServiceImpl implements HabilidadeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private HabilidadeRepository habilidadeRepository;

	@Override
	public void salvar(Habilidade t) {
		habilidadeRepository.save(t);

	}

	@Override
	public void editar(Habilidade t) {
		habilidadeRepository.save(t);

	}

	@Override
	public List<Habilidade> listar() {
		return habilidadeRepository.findAll();
	}

	@Override
	public Habilidade buscarPorId(Long id) {
		return habilidadeRepository.findBy(id);
	}

	@Override
	public void remover(Habilidade t) {
		habilidadeRepository.remove(t);
	}

	@Override
	public EntityRepository<Habilidade, Long> getRepository() {
		return habilidadeRepository;
	}

	@Override
	public void alterarStatus(Habilidade t) {
		t.alterarStatus();
		habilidadeRepository.save(t);
	}

}
