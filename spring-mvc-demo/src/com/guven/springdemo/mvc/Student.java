package com.guven.springdemo.mvc;

import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;

public class Student {
  
	@NotNull(message="This field required")
	private String firstName;

	private String lastName;

	private String country;

	private LinkedHashMap<String, String> countryOptions;

	private String favoriteLanguage;

	private LinkedHashMap<String, String> favoriteLanguageOptions;
	
	private String[] operatinSystems;
	
	private LinkedHashMap<String, String> operationSystemOptions;

	public Student() {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("TR", "Türkiye");

		favoriteLanguageOptions = new LinkedHashMap<>();
		favoriteLanguageOptions.put("Java", "Java");
		favoriteLanguageOptions.put("C#", "C#");
		favoriteLanguageOptions.put("PHP", "PHP");
		favoriteLanguageOptions.put("Ruby", "Ruby");
		
		operationSystemOptions= new LinkedHashMap<>();
		operationSystemOptions.put("Linux", "Linux");
		operationSystemOptions.put("Windows", "Windows");
		operationSystemOptions.put("Mac OS", "MacOs");

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public String[] getOperatinSystems() {
		return operatinSystems;
	}

	public void setOperatinSystems(String[] operatinSystems) {
		this.operatinSystems = operatinSystems;
	}

	public LinkedHashMap<String, String> getOperationSystemOptions() {
		return operationSystemOptions;
	}

	
	
}
