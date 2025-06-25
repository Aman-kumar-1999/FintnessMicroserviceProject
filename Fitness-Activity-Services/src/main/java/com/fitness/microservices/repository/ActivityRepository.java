package com.fitness.microservices.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitness.microservices.model.Activity;

public interface ActivityRepository extends MongoRepository<Activity, String> {
	public boolean existsByUserId(String userId);
	public Optional<Activity> findByUserId(String userId);
	public void deleteByUserId(String userId);
}
