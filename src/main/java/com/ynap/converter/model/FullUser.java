package com.ynap.converter.model;

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

	
	
	
    
}
