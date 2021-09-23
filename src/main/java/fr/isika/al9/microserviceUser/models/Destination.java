package fr.isika.al9.microserviceUser.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="destinations")
public class Destination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nom;
	
	private String nomPaysEnAnglais;
	
	private String nomPays;
	
	private double latitude;
	private double longitude;
	
	@Lob
	private String presentation;

	public Destination(int id, String nom, String nomPaysEnAnglais, String nomPays, String presentation, double lat, double lon) {
		this.id = id;
		this.nom = nom;
		this.nomPaysEnAnglais = nomPaysEnAnglais;
		this.nomPays = nomPays;
		this.presentation = presentation;
		this.setLatitude(lat);
		this.setLongitude(lon);
	}
	
	public Destination( String nom, String nomPaysEnAnglais, String nomPays, String presentation) {
		this.nom = nom;
		this.nomPaysEnAnglais = nomPaysEnAnglais;
		this.nomPays = nomPays;
		this.presentation = presentation;
	}
	
	public Destination() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomPaysEnAnglais() {
		return nomPaysEnAnglais;
	}

	public void setNomPaysEnAnglais(String nomPaysEnAnglais) {
		this.nomPaysEnAnglais = nomPaysEnAnglais;
	}

	public String getNomPays() {
		return nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
