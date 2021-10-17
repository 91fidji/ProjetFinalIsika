package fr.isika.al9.microserviceUser.controllers;

import java.security.Principal;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.isika.al9.microserviceUser.models.Devis;
import fr.isika.al9.microserviceUser.models.User;
import fr.isika.al9.microserviceUser.services.DevisService;
import fr.isika.al9.microserviceUser.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/devis")
public class DevisController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DevisService devisService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/findAll")
	public Iterable<Devis> findAll(){
		return devisService.findAll();
	}
	
	@PostMapping(path="/createDevis")
	public void createDevis(@RequestBody Devis devis) {
		Principal principal = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Optional<User> user = userService.findUserByEmail(principal.getName());
		log.info("user", user);
		devis.setUser(user.get());
		devisService.createDevis(devis);
	}


}
