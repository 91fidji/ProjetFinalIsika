package fr.isika.al9.microserviceUser.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.isika.al9.microserviceUser.dao.RoleRepository;
import fr.isika.al9.microserviceUser.models.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	/**
	 * Find a role
	 * @param role
	 * @return role
	 */
	public Role findByRole(String role) {
		return roleRepository.findByRole(role);
	}

	/**
	 * Find all registered roles
	 * @return List<Role>
	 */
	public List<Role> findAll() {
		return (List<Role>) roleRepository.findAll();
	}
	
	public Role findByName(String roleName) {
		return roleRepository.findByRole(roleName);
	}
	
	/**
	 * Create a new role
	 * @param role
	 */
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}
	
	/**
	 * Delete a role
	 * @param role
	 */
	public void deleteRole(Integer role) {
		roleRepository.deleteById(role);
	}

}
