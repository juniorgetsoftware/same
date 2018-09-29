package br.com.same.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.same.models.Gabarito;

@Repository
@ApplicationScoped
public interface GabaritoRepository extends EntityRepository<Gabarito, Long> {

}
