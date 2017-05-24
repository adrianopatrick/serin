package br.unifor.mia.serin.rest;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.mia.serin.entity.Schema;
import br.unifor.mia.serin.service.SchemaService;

@RestController
public class SchemaRest {

	@Inject
	private SchemaService schemaService;

	@RequestMapping(value = "/schema", method = RequestMethod.GET)
	public ResponseEntity<Schema> getSchemaByName(@RequestParam(value = "name") String name,
			@RequestParam(value = "version", required = false) String version) {
		System.out.println("[INFO] CALL SCHEMA");
		try {
			Schema schema = this.schemaService.getSchema(name, version);
			if (schema != null) {
				return new ResponseEntity<>(schema, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
