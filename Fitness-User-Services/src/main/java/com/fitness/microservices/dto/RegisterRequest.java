package com.fitness.microservices.dto;

import com.fitness.microservices.model.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
	
	@NotBlank(message = "Email is required.")
	@Email(message = "Invalid Email formate.")
	private String email;
	
	@NotBlank(message = "Password whould not be blank.")
	@Size(min = 6, message = "Password must have atleast 6 Charectors .")
	private String password;
	private String firstName;
	private String lastName;
	
	public static User convertRegisterToUser(RegisterRequest registerRequest) {
		
		User user = new User();
		
		user.setEmail(registerRequest.getEmail());
		user.setPassword(registerRequest.getPassword());
		user.setFirstName(registerRequest.getFirstName());
		user.setLastName(registerRequest.getLastName());
		
		return user;
	}
	
}
