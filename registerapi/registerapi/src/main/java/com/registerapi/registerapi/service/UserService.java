package com.registerapi.registerapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registerapi.registerapi.repositry.PasswordRepository;
import com.registerapi.registerapi.repositry.LoginRepository;
import com.registerapi.registerapi.repositry.UserRepository;
import com.registerapi.registerapi.repositry.UserRoleRepository;
import com.registerapi.registerapi.user.UserPassword;
import com.registerapi.registerapi.user.UserRole;
import com.registerapi.registerapi.user.User;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	private final UserRepository userRepository;

	private final PasswordRepository passwordRepository;
	private final LoginRepository loginrepository;
	private final UserRoleRepository userRoleRepository;

	@Autowired
	public UserService(UserRepository userRepository, PasswordRepository passwordRepository,
			LoginRepository loginrepository, UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.passwordRepository = passwordRepository;
		this.loginrepository = loginrepository;
		this.userRoleRepository = userRoleRepository;
	}

	public User registerUser(String firstName, String lastName, String email, Long phoneno) {
		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmaild(email);
		newUser.setPhoneno(phoneno);

		return userRepository.save(newUser);
	}

	public String saveRole(String emailId, String role) {
		UserRole userRole = new UserRole();
		userRole.setEmailId(emailId);
		userRole.setRole(role);
		UserRole savedRole = userRoleRepository.save(userRole);
		return savedRole.getRole();

	}

	public UserPassword registerUser(String emaild, String password) {
		UserPassword newDepart = new UserPassword();
		newDepart.setEmaild(emaild);
		newDepart.setPassword(password);
		return passwordRepository.save(newDepart);

	}

	@Transactional
	public String savePassword(String email, String password) {
		// Check if the user exists in the company_user table
		Optional<User> optionalUser = userRepository.findById(email);
		if (!optionalUser.isPresent()) {
			return "User with the provided email does not exist.";
		}

		// Save the password in the users_password table
		UserPassword userPass = new UserPassword();
		userPass.setEmaild(email);
		userPass.setPassword(password);
		passwordRepository.save(userPass);

		return "Password saved successfully.";
	}

	public boolean checkEmailAndPassword(String email, String password) {
		Optional<UserPassword> optUserpassword = passwordRepository.findById(email);
		if (optUserpassword.isPresent()) {
			UserPassword userPassword = optUserpassword.get();
			if (userPassword.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}

	}

	public String getUserRole(String email) {
		Optional<UserRole> optionalUserRole = userRoleRepository.findById(email);
		return optionalUserRole.get().getRole();

	}
}
