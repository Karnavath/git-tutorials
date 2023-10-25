package com.registerapi.registerapi.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registerapi.registerapi.user.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {

}
