package br.com.same.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.AlunoProva;

@Repository
public interface AlunoGabaritoRepository extends EntityRepository<AlunoProva, Long> {

}
