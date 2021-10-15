package fr.isika.al9.microserviceUser.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.isika.al9.microserviceUser.models.Erole;
import fr.isika.al9.microserviceUser.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	
	public Role findByRole(String role);
	public Optional<Role> findByRole(Erole role);

	
	public void deleteById(Integer id);

}
