package fr.isika.al9.microserviceUser.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.isika.al9.microserviceUser.dao.DevisRepository;
import fr.isika.al9.microserviceUser.models.Devis;

@Service
public class DevisService {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DevisRepository devisRepository;
	
	public Iterable<Devis> findAll(){
		return devisRepository.findAll();
	}
	
	public void createDevis(Devis devis) {
		devisRepository.save(devis);
	}

}
