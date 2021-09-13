package fr.isika.al9.microserviceUser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.isika.al9.microserviceUser.models.Devis;
import fr.isika.al9.microserviceUser.services.DevisService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/devis")
public class DevisController {
	
	@Autowired
	private DevisService devisService;
	
	@GetMapping(path="/findAll")
	public Iterable<Devis> findAll(){
		return devisService.findAll();
	}
	
	@PostMapping(path="/createDevis")
	public void createDevis(@RequestBody Devis devis) {
		devisService.createDevis(devis);
	}


}
