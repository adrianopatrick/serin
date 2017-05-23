package br.unifor.mia.serin.rest;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.mia.serin.entity.Domains;
import br.unifor.mia.serin.service.DomainService;

@RestController
public class DomainRest {

	@Inject
	private DomainService domainService;

	@RequestMapping(value = "/domain", method = RequestMethod.GET)
	public ResponseEntity<Domains> getDomainByName(@RequestParam(value = "name") String name) {
		try {
			System.out.println("RESQUEST NAME: " + name);
			Domains domain = this.domainService.getDomainByName(name);
			if (domain != null) {
				System.out.println("DOMAINS:" + domain.getTabelas());
				return new ResponseEntity<>(domain, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
