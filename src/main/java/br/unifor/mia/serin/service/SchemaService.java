package br.unifor.mia.serin.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.unifor.mia.serin.entity.Schema;
import br.unifor.mia.serin.repository.SchemaRepository;

@Service
public class SchemaService {

	@Inject
	private SchemaRepository schemaRepository;

	public Schema getSchema(String name, String version) {
		if (version == null) {
			return this.schemaRepository.findByName(name);
		}
		return this.schemaRepository.findByNameAndVersion(name, version);
	}
}
