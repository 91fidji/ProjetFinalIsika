package fr.isika.al9.microserviceUser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import fr.isika.al9.microserviceUser.controllers.RoleController;
import fr.isika.al9.microserviceUser.models.Role;

class MicroServiceRollApplicationTests {
	@Autowired
	private RoleController roleController;

	@Test
	@Rollback(false)
	void shouldCreateARole() {
		Role role = new Role();
		role.setRole("test");
		roleController.createRole(role);
		
		Role roleATester = roleController.getRoleByName("test");
		//assertThat(roleATester.getRole().isEqualTo(role.getRole()));
	}

}
