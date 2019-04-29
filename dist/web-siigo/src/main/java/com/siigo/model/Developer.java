package com.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Developer {

	@JsonProperty("Id")
	private Long id;
	@JsonProperty("FirstName")
	private String firstName;
	@JsonProperty("LastName")
	private String lastName;
	@JsonProperty("IsActive")
	private int isActivate;

	public Developer() {

	}

	public Developer(Long id, String firstName, String lastName, int isActivate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActivate = isActivate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getIsActivate() {
		return isActivate;
	}

	public void setIsActivate(int isActivate) {
		this.isActivate = isActivate;
	}

	@Override
	public String toString() {
		return "Developer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", isActivate="
				+ isActivate + "]";
	}
}
