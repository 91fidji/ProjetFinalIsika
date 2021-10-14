package fr.isika.al9.microserviceUser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.isika.al9.microserviceUser.dao.CountryRepository;
import fr.isika.al9.microserviceUser.models.Country;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;

	public Iterable<Country> getAllDestination() {
		return countryRepository.findAll();
	}

	public Country addCountry(Country country) {
		return this.countryRepository.save(country);
	}

}
