package br.unifor.mia.serin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.unifor.mia.serin.entity.Schema;

public interface SchemaRepository extends CrudRepository<Schema, Long> {

	Schema findByName(@Param("name") String name);

	Schema findByNameAndVersion(@Param("name") String name, @Param("version") String version);

}
