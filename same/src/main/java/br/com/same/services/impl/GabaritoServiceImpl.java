package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Gabarito;
import br.com.same.models.Turma;
import br.com.same.repository.GabaritoRepository;
import br.com.same.services.GabaritoService;

public class GabaritoServiceImpl implements GabaritoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private GabaritoRepository gabaritoRepository;

	@Override
	public void salvar(Gabarito gabarito) {
		gabaritoRepository.save(gabarito);
	}

	@Override
	public List<Gabarito> listar() {
		return gabaritoRepository.findAll();
	}

	@Override
	public Gabarito buscarPorId(Long id) {
		return gabaritoRepository.findBy(id);
	}

	@Override
	public void remover(Gabarito gabarito) {
		gabaritoRepository.remove(gabarito);
	}

	@Override
	public void editar(Gabarito gabarito) {
		gabaritoRepository.save(gabarito);
	}

	@Override
	public EntityRepository<Gabarito, Long> getRepository() {
		return this.gabaritoRepository;
	}

	@Override
	public List<Gabarito> listar(Turma turma) {
		return gabaritoRepository.findByTurmaOrderByTitulo(turma);
	}

	@Override
	public void alterarStatus(Gabarito gabarito) {
		gabarito.alterarStatus();
		this.editar(gabarito);
	}
}
