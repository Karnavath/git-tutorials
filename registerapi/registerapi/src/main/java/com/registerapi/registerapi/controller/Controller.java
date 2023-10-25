package com.registerapi.registerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.registerapi.registerapi.dto.UserDto;
import com.registerapi.registerapi.service.UserService;
import com.registerapi.registerapi.user.User;
import com.registerapi.registerapi.user.UserPassword;
import com.registerapi.registerapi.user.User_login;

@RestController
@RequestMapping("/registeredUsers")

public class Controller {

	private final UserService userService;

	@Autowired
	public Controller(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
		// it is for save user data only
		User newUser = userService.registerUser(userDto.getFirstName(), userDto.getLastName(), userDto.getEmaild(),
				userDto.getPhoneno());
		// it is for save role only
		String userRole = userService.saveRole(userDto.getEmaild(), userDto.getRole());

		return ResponseEntity.ok(newUser);
	}

	@PostMapping("/password")
	public ResponseEntity<String> registerUsers(@RequestBody UserPassword userPassword) {
		String response = userService.savePassword(userPassword.getEmaild(), userPassword.getPassword());
		return ResponseEntity.ok(response);
	}

	@PostMapping("/login")
	public ResponseEntity<String> registerUsers(@RequestBody User_login loginRequest) {
		String email = loginRequest.getEmail();
		String password = loginRequest.getPassword();
		boolean result = userService.checkEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
		if (result) {
			String userRole = userService.getUserRole(loginRequest.getEmail());
			return ResponseEntity.ok(userRole);
		} else {
			return ResponseEntity.ok("invalid credentials");
		}

	}

//	@GetMapping("/otp")
//	public ResponseEntity<String> generateOTP(@RequestParam String email) {
//		// Check if email exists in database
//		String otp = userService.generateOTP();
//		// Send otp to email
//		return ResponseEntity.ok(otp);
//	}

	/*
	 * @PostMapping("/verify") public ResponseEntity<String> verifyOTP(@RequestBody
	 * Otp otpDto) { // Check if otpDto matches with generated otp if (((Object)
	 * otpDto).getOtp().equals(otp)) { return ResponseEntity.ok("Verified"); } else
	 * { return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
	 * } }
	 */
}
