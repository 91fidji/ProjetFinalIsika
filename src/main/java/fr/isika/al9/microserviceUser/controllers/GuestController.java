package fr.isika.al9.microserviceUser.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.isika.al9.microserviceUser.models.Guest;
import fr.isika.al9.microserviceUser.services.GuestService;

@RestController
@RequestMapping(path="/guest")
@CrossOrigin(origins = "http://localhost:4200")

public class GuestController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GuestService guestService;
	
	@GetMapping(path="/findAll")
	public Iterable<Guest> findAll() {
		return this.guestService.findAll();
	}
	
	@GetMapping("/getByEmail/{email}")
	public Guest getByEmail(@PathVariable String email) {
		log.info("email "+email);
		return this.guestService.getByEmail(email);
	}
	
	@PostMapping("createGuest")
	public @ResponseBody Guest createGuest(@RequestBody Guest guest) {
		log.info("guest "+guest);
		return this.guestService.addGuest(guest);
	}

}
