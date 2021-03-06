package fr.isika.al9.microserviceUser.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.isika.al9.microserviceUser.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public void deleteById(Integer id);
	
	User findByEmail(String email);
	
	List<User> findByRoles(String role);

}
