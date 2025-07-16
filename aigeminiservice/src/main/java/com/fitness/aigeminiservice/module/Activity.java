package com.fitness.aigeminiservice.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;


@Data
public class Activity {
	
	private String id;
	private String userId;
	private Integer duration;
	private Integer caloriesBurn;
	private LocalDateTime startTime;
	private Map<String,Object> additionalMetrics;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	
	

}
