package com.ynap.converter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class UserPreference {
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("UserPreferenceValue")
	private UserPreferenceValue userPreferenceValue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserPreferenceValue getUserPreferenceValue() {
		return userPreferenceValue;
	}

	public void setUserPreferenceValue(UserPreferenceValue userPreferenceValue) {
		this.userPreferenceValue = userPreferenceValue;
	}

}
