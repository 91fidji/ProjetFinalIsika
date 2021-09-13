package fr.isika.al9.microserviceUser.controllers;

import java.util.List;
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

import fr.isika.al9.microserviceUser.models.Role;
import fr.isika.al9.microserviceUser.services.RoleService;

@RestController
@RequestMapping(path="/role")
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RoleService roleService;
	

	@GetMapping("/listRoles")
	/**
	 *  Get all registered roles
	 * @return List<Role>
	 */
	public @ResponseBody List<Role> findRoles() {
		return roleService.findAll();
	}
	
	@GetMapping("/getRoleByName/{roleName}")
	public Role getRoleByName(@PathVariable String roleName) {
		return roleService.findByName(roleName);
	}
	
	@PostMapping("/createRole")
	public Role createRole(@RequestBody Role role) {
		return roleService.createRole(role);
	}
	
	@DeleteMapping("/deleteRole/{roleId}")
	public void deleteRole(@PathVariable Integer roleId) {
		log.info("delete", roleId);
		roleService.deleteRole(roleId);
	}
	

}
