package com.fitness.microservices.services;



import java.util.List;

import com.fitness.microservices.dto.RegisterRequest;
import com.fitness.microservices.dto.UpdaterRequest;
import com.fitness.microservices.dto.UserResponse;

public interface UserServices {
	
	public UserResponse getByEmail(String email);
	
	public List<UserResponse> getAllData();
	
	public UserResponse register(RegisterRequest register);

	public boolean existsByEmail(String email);
	
	public UserResponse updateUser(UpdaterRequest updaterRequest);
	
	public void deleteUser(String email);
	

}
