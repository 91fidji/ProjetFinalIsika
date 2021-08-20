package fr.isika.al9.microserviceUser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
		
	@GetMapping(path="/listUser")
	public @ResponseBody Iterable<User> listUser() {
		return userService.findAll();
	}
	
}
