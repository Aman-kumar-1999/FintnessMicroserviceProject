package com.fitness.microservices.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.microservices.dto.RegisterRequest;
import com.fitness.microservices.dto.UpdaterRequest;
import com.fitness.microservices.dto.UserResponse;
import com.fitness.microservices.model.User;
import com.fitness.microservices.repositoty.UserRepository;
import com.fitness.microservices.services.UserServices;

@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public UserResponse getByEmail(String email) {
		return UserResponse.convertUserToUserResponse(userRepository.findByEmail(email).get());
	}

	@Override
	public UserResponse register(RegisterRequest register) {
		
		/*
		 * if(existsByEmail(register.getEmail())) { throw new
		 * RuntimeException("Email already exists"); }
		 */
		
		return UserResponse.convertUserToUserResponse(userRepository.save(RegisterRequest.convertRegisterToUser(register)));
	}

	@Override
	public boolean existsByEmail(String email) {
		
		return userRepository.existsByEmail(email);
	}

	@Override
	public List<UserResponse> getAllData() {
		return userRepository
				.findAll()
				.stream()
				.map(user -> UserResponse.convertUserToUserResponse(user))
				.collect(Collectors.toList());
	}

	@Override
	public UserResponse updateUser(UpdaterRequest updaterRequest) {
		
		User newUser = userRepository.findByEmail(updaterRequest.getEmail()).get();
		newUser.setFirstName(updaterRequest.getFirstName());
		newUser.setLastName(updaterRequest.getLastName());
		newUser.setPassword(updaterRequest.getPassword());
		newUser.setRole(updaterRequest.getRole());
		return UserResponse.convertUserToUserResponse(userRepository.save(newUser));
	}

	@Override
	public void deleteUser(String email) {
		userRepository.deleteByEmail(email);
		
	}

	@Override
	public Boolean validateById(String id) {
		return userRepository.existsById(id);
	}


}
