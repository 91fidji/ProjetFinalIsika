package fr.isika.al9.microserviceUser.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author olivierbisson
 *
 */
@Document()
@Data public class User {
	
	@Id
	private String id;
	private String name;
	private String firstname;
	private String email;
	private String password;

}
