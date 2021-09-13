package fr.isika.al9.microserviceUser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.isika.al9.microserviceUser.dao.GuestRepository;
import fr.isika.al9.microserviceUser.models.Guest;

@Service
public class GuestService {
	@Autowired
	private GuestRepository guestRepository;
	
	public Iterable<Guest> findAll() {
		return this.guestRepository.findAll();
	}

}
