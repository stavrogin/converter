package com.ynap.converter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class FullUser {

	@JsonProperty("UserRegType")
	private String userRegType;
	
	@JsonProperty("Brand")
	private String brand;
	
	@JsonProperty("RegisteredCountry")
	private String registeredCountry;
	
	@JsonProperty("FirstName")
	private String firstName;
	
	@JsonProperty("LastName")
	private String lastName;
	
	@JsonProperty("LegacyUserId")
	private String legacyUserId;
	
	@JsonProperty("Email")
	private String email;
	
	@JsonProperty("Gender")
	private String gender;
	
	@JsonProperty("DateOfBirth")
	private String dateOfBirth;
	
	@JsonProperty("PrimaryPhone")
	private String primaryPhone;
	
	@JsonProperty("RegistrationDateTime")
	private String registrationDateTime;
	
	@JsonProperty("LastUpdate")
	private String lastUpdate;
	
	@JsonProperty("AccountStatus")
	private String accountStatus;
	
	@JsonProperty("RegistrationSource")
	private String registrationSource;
	
	@JsonProperty("Roles")
	private Roles roles;
	
	@JsonProperty("Pronunciation")
	private Pronunciation pronunciation;
	
	@JsonProperty("ContextAttribute")
	private List<ContextAttribute> contextAttribute;
	
	@JsonProperty("UserPreference")
	private UserPreference userPreference;

	
	// getters and setters 
	
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
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

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Pronunciation getPronunciation() {
		return pronunciation;
	}

	public void setPronunciation(Pronunciation pronunciation) {
		this.pronunciation = pronunciation;
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
