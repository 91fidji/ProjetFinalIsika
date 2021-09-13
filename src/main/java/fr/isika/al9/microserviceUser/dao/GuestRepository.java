package fr.isika.al9.microserviceUser.dao;

import org.springframework.data.repository.CrudRepository;

import fr.isika.al9.microserviceUser.models.Guest;

public interface GuestRepository extends CrudRepository<Guest, Integer> {

}
