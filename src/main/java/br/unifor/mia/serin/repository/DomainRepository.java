package br.unifor.mia.serin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.unifor.mia.serin.entity.Domains;

public interface DomainRepository extends CrudRepository<Domains, Long>{
	
	Domains findByName(@Param("name") String name);

}
