package com.fitness.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessUserServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessUserServicesApplication.class, args);
		System.out.println("Our User Service Program is running >>>>>>>>>> ............");
	}

}
