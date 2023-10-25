package com.registerapi.registerapi.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registerapi.registerapi.user.UserPassword;
import com.registerapi.registerapi.user.User_login;

public interface LoginRepository extends JpaRepository<User_login, String> {
	//user login find by email
	UserPassword findByEmail(String emaild);
}
