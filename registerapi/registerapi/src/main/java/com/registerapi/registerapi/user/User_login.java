package com.registerapi.registerapi.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_password")
public class User_login {
	@Id
	@Column(name = "email_id")
	private String email;

	@Column(name = "password")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User_login [email=" + email + ", password=" + password + "]";
	}
///

}
