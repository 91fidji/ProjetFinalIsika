package fr.isika.al9.microserviceUser.controllers;

import java.util.Optional;
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

import fr.isika.al9.microserviceUser.models.Destination;
import fr.isika.al9.microserviceUser.services.DestinationService;

@RestController
@RequestMapping(path="/destination")
@CrossOrigin(origins = "http://localhost:4200")
public class DestinationController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DestinationService destinationService;
	
	@GetMapping("listDestination")
	public @ResponseBody Iterable<Destination> getAllDestination(){
		return destinationService.getAllDestination();
	}
	
	@GetMapping("findDestination/{id}")
	public Optional<Destination> getDestinationById(@PathVariable int id) {
		return destinationService.getDestinationById(id);
	}
	
	@PostMapping("addDestination")
	public @ResponseBody Destination addDestination(@RequestBody Destination destination) {
		return this.destinationService.addDestination(destination);
	}

}
