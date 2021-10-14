package fr.isika.al9.microserviceUser.dao;

import org.springframework.data.repository.CrudRepository;

import fr.isika.al9.microserviceUser.models.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}
