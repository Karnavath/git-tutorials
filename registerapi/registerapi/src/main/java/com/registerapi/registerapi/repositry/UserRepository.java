package com.registerapi.registerapi.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import com.registerapi.registerapi.user.User;

public interface UserRepository extends JpaRepository<User, String> {

}
