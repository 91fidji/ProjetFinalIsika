package fr.isika.al9.microserviceUser.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.isika.al9.microserviceUser.models.Country;
import fr.isika.al9.microserviceUser.services.CountryService;

@RestController
@RequestMapping(path="countries")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CountryService countryService;
	
	@GetMapping("listCountries")
	public @ResponseBody Iterable<Country> getAllDestination(){
		return countryService.getAllDestination();
	}

	@PostMapping("addCountry")
	public @ResponseBody Country addCountry(@RequestBody Country country) {
		return this.countryService.addCountry(country);
	}
}
