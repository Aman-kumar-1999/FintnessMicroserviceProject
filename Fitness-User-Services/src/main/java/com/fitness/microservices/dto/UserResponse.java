package com.fitness.microservices.dto;

import java.time.LocalDateTime;

import com.fitness.microservices.model.User;
import com.fitness.microservices.model.UserRole;


import lombok.Data;

@Data
public class UserResponse {

	private String id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private UserRole role = UserRole.USER;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	//private String message;
	
	public static User convertUserResponseToUser(UserResponse userResponse) {
		User user = new User();
		
		user.setId(userResponse.getId());
		user.setEmail(userResponse.getEmail());
		user.setPassword(userResponse.getPassword());
		user.setFirstName(userResponse.getFirstName());
		user.setLastName(userResponse.getLastName());
		user.setRole(userResponse.getRole());
		user.setCreatedAt(userResponse.getCreatedAt());
		user.setUpdatedAt(userResponse.getUpdatedAt());
		
		return user;
	}

	public static UserResponse convertUserToUserResponse(User user) {
		UserResponse userResponse = new UserResponse();
		
		userResponse.setId(user.getId());
		userResponse.setEmail(user.getEmail());
		userResponse.setPassword(user.getPassword());
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		userResponse.setRole(user.getRole());
		userResponse.setCreatedAt(user.getCreatedAt());
		userResponse.setUpdatedAt(user.getUpdatedAt());
		
		return userResponse;
	}
}
