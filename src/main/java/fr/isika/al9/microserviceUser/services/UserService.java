package fr.isika.al9.microserviceUser.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.isika.al9.microserviceUser.dao.UserRepository;
import fr.isika.al9.microserviceUser.models.User;
@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
