package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Prova;
import br.com.same.repository.ProvaRepository;
import br.com.same.services.ProvaService;

public class ProvaServiceImpl implements ProvaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ProvaRepository provaRepository;

	@Override
	public void salvar(Prova prova) {
		provaRepository.save(prova);
	}

	@Override
	public List<Prova> listar() {
		return provaRepository.findAll();
	}

	@Override
	public Prova buscarPorId(Long id) {
		return provaRepository.findBy(id);
	}

	@Override
	public void remover(Prova prova) {
		provaRepository.remove(prova);
	}

	@Override
	public void editar(Prova prova) {
		provaRepository.save(prova);
	}

	@Override
	public EntityRepository<Prova, Long> getRepository() {
		return this.provaRepository;
	}

}
