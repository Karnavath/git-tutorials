package com.registerapi.registerapi.dto;

import jakarta.persistence.Column;

public class UserDto {
	
	private String emaild;

	private Long phoneno;

	private String firstName;

	private String lastName;
	
	private String role;

	public String getEmaild() {
		return emaild;
	}

	public void setEmaild(String emaild) {
		this.emaild = emaild;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
