package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Gabarito;
import br.com.same.repository.GabaritoRepository;
import br.com.same.services.GabaritoService;

public class GabaritoServiceImpl implements GabaritoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private GabaritoRepository provaRepository;

	@Override
	public void salvar(Gabarito prova) {
		provaRepository.save(prova);
	}

	@Override
	public List<Gabarito> listar() {
		return provaRepository.findAll();
	}

	@Override
	public Gabarito buscarPorId(Long id) {
		return provaRepository.findBy(id);
	}

	@Override
	public void remover(Gabarito prova) {
		provaRepository.remove(prova);
	}

	@Override
	public void editar(Gabarito prova) {
		provaRepository.save(prova);
	}

	@Override
	public EntityRepository<Gabarito, Long> getRepository() {
		return this.provaRepository;
	}

}
