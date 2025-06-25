package com.fitness.microservices.dto;

import com.fitness.microservices.model.User;
import com.fitness.microservices.model.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdaterRequest {
	
	@NotBlank(message = "Email is required.")
	@Email(message = "Invalid Email formate.")
	private String email;
	
	@NotBlank(message = "Password whould not be blank.")
	@Size(min = 6, message = "Password must have atleast 6 Charectors .")
	private String password;
	private String firstName;
	private String lastName;
	private UserRole role;
	
	public static User convertUpdateRequestToUser(UpdaterRequest updaterRequest) {
		
		User user = new User();
		
		user.setEmail(updaterRequest.getEmail());
		user.setPassword(updaterRequest.getPassword());
		user.setFirstName(updaterRequest.getFirstName());
		user.setLastName(updaterRequest.getLastName());
		user.setRole(updaterRequest.getRole());
		return user;
	}

}
