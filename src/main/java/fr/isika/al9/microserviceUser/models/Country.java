package fr.isika.al9.microserviceUser.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
    String name;
    String frenchName;
    String flag;
    String capital;
    String callingCodes;
    String currency;
    String currencyCode;
    Integer population;
    String[] languages;
    String altSpellings;
    String[] translations;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrenchName() {
		return frenchName;
	}
	public void setFrenchName(String frenchName) {
		this.frenchName = frenchName;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getCallingCodes() {
		return callingCodes;
	}
	public void setCallingCodes(String callingCodes) {
		this.callingCodes = callingCodes;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	public String getAltSpellings() {
		return altSpellings;
	}
	public void setAltSpellings(String altSpellings) {
		this.altSpellings = altSpellings;
	}
	public String[] getTranslations() {
		return translations;
	}
	public void setTranslations(String[] translations) {
		this.translations = translations;
	}

}
