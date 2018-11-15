package br.com.same.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Prova;

@Repository
//@ApplicationScoped
public interface ProvaRepository extends EntityRepository<Prova, Long> {

}
