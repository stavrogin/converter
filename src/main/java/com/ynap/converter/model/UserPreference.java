package com.ynap.converter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserPreference {
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("UserPreferenceValue")
	private List<UserPreferenceValue> userPreferenceValue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserPreferenceValue> getUserPreferenceValue() {
		return userPreferenceValue;
	}

	public void setUserPreferenceValue(List<UserPreferenceValue> userPreferenceValue) {
		this.userPreferenceValue = userPreferenceValue;
	}

}
