package com.fitness.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessActivityServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessActivityServicesApplication.class, args);
		
		System.out.println("Activity Services is Running .........");
	}

}
