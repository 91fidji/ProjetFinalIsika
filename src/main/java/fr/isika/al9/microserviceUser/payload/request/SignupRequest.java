package fr.isika.al9.microserviceUser.payload.request;

import java.util.Set;

public class SignupRequest {
	private String email;
	private String name;
	private String firstname;
	private String password;
	private Set<String> roles;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<String> getRoles() {
		return this.roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}


}
