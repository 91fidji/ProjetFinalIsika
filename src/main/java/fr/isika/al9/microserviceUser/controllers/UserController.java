package fr.isika.al9.microserviceUser.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import fr.isika.al9.microserviceUser.models.User;
import fr.isika.al9.microserviceUser.services.UserService;

/**
 * 
 * @author olivierbisson
 * Le 20 Aout 2021
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/user")
public class UserController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
		
	@GetMapping(path="/listUsers")
	public @ResponseBody List<User> listUser() {
		return userService.findAll();
	}
	
	@PostMapping(path="/createUser")
	public void addUser(@RequestBody User user) {
		userService.createUser(user);
	}
	
	@DeleteMapping(path="deleteUser/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/user")
	public Optional<User> user(String userInString, String password) {
		return userService.findUserByEmail(userInString, password);
	}
}
