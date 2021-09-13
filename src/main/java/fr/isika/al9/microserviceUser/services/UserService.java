package fr.isika.al9.microserviceUser.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.isika.al9.microserviceUser.dao.RoleRepository;
import fr.isika.al9.microserviceUser.dao.UserRepository;
import fr.isika.al9.microserviceUser.models.Role;
import fr.isika.al9.microserviceUser.models.User;
@Service
public class UserService {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	
	public void createUser(User user) {
		Role userRole = roleRepository.findByRole(user.getRoles().iterator().next().getRole().toString());
		log.info("r" +userRole);
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

}
