package com.registerapi.registerapi.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_users")
public class User {
	@Id
	@Column(name = "email_id")
	private String emaild;

	@Column(name = "phoneno")
	private Long phoneno;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

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

	public String getEmaild() {
		return emaild;
	}

	public void setEmaild(String emaild) {
		this.emaild = emaild;
	}

	public User(Long phoneno, String firstName, String lastName, String emaild) {
		super();
		this.phoneno = phoneno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emaild = emaild;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [phoneno=" + phoneno + ", firstName=" + firstName + ", lastName=" + lastName + ", emaild=" + emaild
				+ "]";
	}

}