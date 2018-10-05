package br.com.same.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.data.api.EntityRepository;

import br.com.same.models.Escola;
import br.com.same.models.PeriodoLetivo;
import br.com.same.repository.PeriodoLetivoRepository;
import br.com.same.services.PeriodoLetivoService;

public class PeriodoLetivoServiceImpl implements PeriodoLetivoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PeriodoLetivoRepository periodoLetivoRepository;

	@Override
	public PeriodoLetivo buscarPorId(Long id) {
		return periodoLetivoRepository.findBy(id);
	}

	@Override
	public void salvar(PeriodoLetivo periodoLetivo) {
		periodoLetivoRepository.save(periodoLetivo);
	}

	@Override
	public void editar(PeriodoLetivo periodoLetivo) {
		periodoLetivoRepository.save(periodoLetivo);
	}

	@Override
	public List<PeriodoLetivo> listar() {
		return periodoLetivoRepository.findAll();
	}

	@Override
	public void remover(PeriodoLetivo periodoLetivo) {
		periodoLetivoRepository.remove(periodoLetivo);
	}

	@Override
	public EntityRepository<PeriodoLetivo, Long> getRepository() {
		return periodoLetivoRepository;
	}

	@Override
	public List<PeriodoLetivo> listar(Escola escola) {
		return periodoLetivoRepository.findByEscolaOrderByNome(escola);
	}

	@Override
	public void alterarStatus(PeriodoLetivo periodo) {
		periodo.alterarStatus();
		this.editar(periodo);
	}
}
