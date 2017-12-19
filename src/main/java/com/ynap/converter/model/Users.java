package com.ynap.converter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Users<T> {
	
	@JsonProperty("User")
	private List<T> users;

	//getters and setters
	public List<T> getUsers() {
		return users;
	}

	public void setUsers(List<T> users) {
		this.users = users;
	}

}
