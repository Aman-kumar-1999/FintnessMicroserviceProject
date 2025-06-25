package com.fitness.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FitnessEurekaServerServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessEurekaServerServicesApplication.class, args);
		System.out.println("Service Registry is Running .............");
	}

}
