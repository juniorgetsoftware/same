package br.com.same.repository;

import java.io.Serializable;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Habilidade;

@Repository
public interface HabilidadeRepository extends EntityRepository<Habilidade, Long>, Serializable {

}
