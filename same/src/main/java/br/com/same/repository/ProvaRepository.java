package br.com.same.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Prova;

@Repository
public interface ProvaRepository extends EntityRepository<Prova, Long> {

}
