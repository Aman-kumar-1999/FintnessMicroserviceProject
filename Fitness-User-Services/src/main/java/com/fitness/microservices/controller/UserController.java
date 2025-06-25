package com.fitness.microservices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fitness.microservices.dto.RegisterRequest;
import com.fitness.microservices.dto.UpdaterRequest;
import com.fitness.microservices.dto.UserResponse;
import com.fitness.microservices.services.UserServices;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

@RestController
@RequestMapping("/api/v1/users")
@RestControllerAdvice
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	
	@GetMapping("/{email}")
	public ResponseEntity<Map<String,Object>> getUser(@Email(message = "Invalid Email formate") @PathVariable String email){
		
		Map<String,Object> map = new HashMap<>();
		if(userServices.existsByEmail(email)) {
			
			UserResponse userResponse = userServices.getByEmail(email);
			map.put("STATUS", "SUCCESS");
			map.put("USER", userResponse);
			return ResponseEntity.ok(map);
			
			
		}else {
			map.put("STATUS", "ERROR");
			map.put("MSG", "Email not exists");
			
			return ResponseEntity.ok(map);
		}
		
		//return ResponseEntity.ok(userServices.getByEmail(email));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserResponse>> getAllUser(){
		return ResponseEntity.ok(userServices.getAllData());
	}
	
	
	@PostMapping("/")
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,Object>> setUser(@Valid @RequestBody RegisterRequest register){
		Map<String,Object> map = new HashMap<>();
		if(userServices.existsByEmail(register.getEmail())) {
			map.put("STATUS", "ERROR");
			map.put("MSG", "Email already exists");
			
			return ResponseEntity.ok(map);
		}else {
			UserResponse userResponse = userServices.register(register);
			map.put("STATUS", "SUCCESS");
			map.put("USER", userResponse);
			return ResponseEntity.ok(map);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<Map<String,Object>> updateUser(@Valid @RequestBody UpdaterRequest updaterRequest){
		Map<String,Object> map = new HashMap<>();
		if(userServices.existsByEmail(updaterRequest.getEmail())) {
			
			UserResponse userResponse = userServices.updateUser(updaterRequest);
			map.put("STATUS", "SUCCESS");
			map.put("USER", userResponse);
			return ResponseEntity.ok(map);
			
			
		}else {
			map.put("STATUS", "ERROR");
			map.put("MSG", "Email not exists");
			
			return ResponseEntity.ok(map);
		}
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<?> deleteUser(@Email(message = "Invalid Email Formate") @PathVariable String email){
		
		Map<String,Object> map = new HashMap<>();
		if(userServices.existsByEmail(email)) {
			
			userServices.deleteUser(email);
			map.put("STATUS", "SUCCESS");
			//map.put("USER", userResponse);
			return ResponseEntity.ok(map);
			
			
		}else {
			map.put("STATUS", "ERROR");
			map.put("MSG", "Email not exists");
			
			return ResponseEntity.ok(map);
		}
	}

}
