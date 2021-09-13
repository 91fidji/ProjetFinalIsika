package fr.isika.al9.microserviceUser.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.isika.al9.microserviceUser.dao.DestinationRepository;
import fr.isika.al9.microserviceUser.models.Destination;

@Service
public class DestinationService {
	
	@Autowired
	private DestinationRepository destinationRepository;
	
	public Iterable<Destination> getAllDestination(){
		return this.destinationRepository.findAll();
	}

	public Optional<Destination> getDestinationById(int id) {
		return this.destinationRepository.findById(id);
	}

	public Destination addDestination(Destination destination) {
		return this.destinationRepository.save(destination);
	}

}
