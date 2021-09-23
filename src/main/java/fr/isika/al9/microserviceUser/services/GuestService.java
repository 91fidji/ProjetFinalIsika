package fr.isika.al9.microserviceUser.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.isika.al9.microserviceUser.dao.GuestRepository;
import fr.isika.al9.microserviceUser.models.Guest;

@Service
public class GuestService {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GuestRepository guestRepository;
	
	public Iterable<Guest> findAll() {
		return this.guestRepository.findAll();
	}
	
	public Guest getByEmail(String email) {
		return this.guestRepository.findByEmail(email);
	}
	
	public Guest addGuest(Guest guest) {
		log.info("gs"+guest);
		return this.guestRepository.save(guest);
	}

}
