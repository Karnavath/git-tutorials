package com.registerapi.registerapi.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_password")
public class UserPassword {
	@Id
	@Column(name = "email_id")
	private String emaild;
	@Column(name = "password")
	private String password;

	public String getEmaild() {
		return emaild;
	}

	public void setEmaild(String emaild) {
		this.emaild = emaild;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserPassword(String emaild, String password) {
		super();
		this.emaild = emaild;
		this.password = password;
	}

	public UserPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [emaild=" + emaild + ", password=" + password + "]";
	}

}
