package fr.isika.al9.microserviceUser;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class MicroserviceUserApplicationTests {
	

	@Test
	void contextLoads() {
	}
	
	@Test
	@Rollback(false)
	void shouldCreateUser() {
		
		
	}

}
