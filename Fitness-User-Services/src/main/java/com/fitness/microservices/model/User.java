package com.fitness.microservices.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	
	@Id
	/*
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	 * 
	 * @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence",
	 * allocationSize = 1, initialValue = 1)
	 */
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;

	@Enumerated(EnumType.STRING)
	private UserRole role = UserRole.USER;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	
	

}
