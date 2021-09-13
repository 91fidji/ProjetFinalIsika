package fr.isika.al9.microserviceUser.models;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Devis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique=true)
	private Integer devisNumber;
	
	private String nomDevis;
	
	private String createdOn;
	
	private String startingDate;
	
	private String status;

	private String villeDepart;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Guest guest;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="productList", joinColumns = @JoinColumn(name="devis_id"),inverseJoinColumns = @JoinColumn(name="product_id"))
	private Set<Product> produit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getDevisNumber() {
		return devisNumber;
	}

	public void setDevisNumber(Integer devisNumber) {
		this.devisNumber = devisNumber;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Product> getProduit() {
		return produit;
	}

	public void setProduit(Set<Product> produit) {
		this.produit = produit;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getNomDevis() {
		return nomDevis;
	}

	public void setNomDevis(String nomDevis) {
		this.nomDevis = nomDevis;
	}


}
