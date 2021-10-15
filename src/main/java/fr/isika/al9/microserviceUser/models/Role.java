package fr.isika.al9.microserviceUser.models;

import javax.persistence.*;

import lombok.Data;
/**
 * @author olivierbisson
 *
 */

@Data
@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Erole role;
	
	public Role() {}
	
	public Role(int id, Erole role) {
		this.id = id;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Erole getRole() {
		return role;
	}

	public void setRole(Erole role) {
		this.role = role;
	}

}
