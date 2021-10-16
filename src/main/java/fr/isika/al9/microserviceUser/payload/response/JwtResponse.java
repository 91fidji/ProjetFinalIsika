package fr.isika.al9.microserviceUser.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private int id;
	private String email;
	private List<String> roles;

	public JwtResponse(String accesstoken, int id, String email, List<String> roles) {
		this.token = accesstoken;
		this.id = id;
		this.email = email;
		this.roles = roles;
	}
	
	public String getAccessToken() {
		return token;
	}
	
	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}
	
	public String getTokenType() {
		return type;
	}
	
	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}