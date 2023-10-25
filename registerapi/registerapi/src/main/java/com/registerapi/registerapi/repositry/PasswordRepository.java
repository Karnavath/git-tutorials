package com.registerapi.registerapi.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registerapi.registerapi.user.UserPassword;

public interface PasswordRepository extends JpaRepository<UserPassword, String> {

}
