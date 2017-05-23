package br.unifor.mia.serin.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.unifor.mia.serin.entity.Domains;
import br.unifor.mia.serin.repository.DomainRepository;

@Service
public class DomainService {
	
	private final DomainRepository domainRepository;
	
	@Inject
	public DomainService(DomainRepository domainRepository) {
		this.domainRepository = domainRepository;
	}
	
	public Domains getDomainByName(String name){
		return this.domainRepository.findByName(name);
	}
}
