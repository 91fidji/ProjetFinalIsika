package fr.isika.al9.microserviceUser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.isika.al9.microserviceUser.models.Role;

class MicroserviceUserRoleTest {
	@Autowired
	Role role;
	
	@BeforeEach
	public void init() {
		role = new Role();
	}
	
	@Test
	void roleShouldNotBeEmpty() {
		role.setRole("");
	}

	@Test
	void newRoleShouldReturnRole() {
		role.setRole("testeur");
		assertEquals("testeur", role.getRole());
	}
	
	@Test
	void newRoleShouldReturnRoleAndId() {
		role.setRole("testeur");
		role.setId(1);
		Role control = new Role();
		control =role;
		assertEquals(control, role);
	}

}
