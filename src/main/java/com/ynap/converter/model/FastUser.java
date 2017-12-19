package com.ynap.converter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FastUser {

	@JsonProperty("UserRegType")
	private String userRegType;
	
	@JsonProperty("Brand")
	private String brand;
	
	@JsonProperty("RegisteredCountry")
	private String registeredCountry;
	
	@JsonProperty("LegacyUserId")
	private String legacyUserId;
	
	@JsonProperty("Email")
	private String email;
	
	@JsonProperty("RegistrationDateTime")
	private String registrationDateTime;
	
	@JsonProperty("LastUpdate")
	private String lastUpdate;
	
	@JsonProperty("AccountStatus")
	private String accountStatus;
	
	@JsonProperty("RegistrationSource")
	private String registrationSource;
	
	@JsonProperty("ContextAttribute")
	private List<ContextAttribute> contextAttribute;
	
	@JsonProperty("UserPreference")
	private UserPreference userPreference;

//	getters and setters 
	
	public String getUserRegType() {
		return userRegType;
	}

	public void setUserRegType(String userRegType) {
		this.userRegType = userRegType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRegisteredCountry() {
		return registeredCountry;
	}

	public void setRegisteredCountry(String registeredCountry) {
		this.registeredCountry = registeredCountry;
	}

	public String getLegacyUserId() {
		return legacyUserId;
	}

	public void setLegacyUserId(String legacyUserId) {
		this.legacyUserId = legacyUserId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegistrationDateTime() {
		return registrationDateTime;
	}

	public void setRegistrationDateTime(String registrationDateTime) {
		this.registrationDateTime = registrationDateTime;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getRegistrationSource() {
		return registrationSource;
	}

	public void setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
	}

	public List<ContextAttribute> getContextAttribute() {
		return contextAttribute;
	}

	public void setContextAttribute(List<ContextAttribute> contextAttribute) {
		this.contextAttribute = contextAttribute;
	}

	public UserPreference getUserPreference() {
		return userPreference;
	}

	public void setUserPreference(UserPreference userPreference) {
		this.userPreference = userPreference;
	}
	
	

}
