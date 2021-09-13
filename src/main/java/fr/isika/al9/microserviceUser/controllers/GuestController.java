package fr.isika.al9.microserviceUser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.isika.al9.microserviceUser.models.Guest;
import fr.isika.al9.microserviceUser.services.GuestService;

@RestController
@RequestMapping(path="/guest")
@CrossOrigin(origins = "http://localhost:4200")

public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@GetMapping(path="/findAll")
	public Iterable<Guest> findAll() {
		return this.guestService.findAll();
	}

}
