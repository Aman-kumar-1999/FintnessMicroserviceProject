package com.fitness.microservices.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Activity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
	
	private String id;
	private String userId;
	private ActivityType type;
	private Integer duration;
	private Integer caloriesBurn;
	private LocalDateTime startTime;
	
	@Field("metrics")
	private Map<String,Object> additionalMetrics;
	
	@CreatedDate
	private LocalDateTime createAt;
	
	@LastModifiedDate
	private LocalDateTime updateAt;
	
	
	

}
