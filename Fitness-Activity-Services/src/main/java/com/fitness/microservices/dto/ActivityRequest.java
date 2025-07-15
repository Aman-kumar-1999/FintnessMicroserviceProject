package com.fitness.microservices.dto;

import java.time.LocalDateTime;
import java.util.Map;



import com.fitness.microservices.model.Activity;
import com.fitness.microservices.model.ActivityType;

import lombok.Data;

@Data
public class ActivityRequest {
	
	
	private String userId;
	private ActivityType type;
	private Integer duration;
	private Integer caloriesBurn;
	private LocalDateTime startTime;
	private Map<String, Object> additionalMetrics;
	
	public static Activity convertActivityRequestToActivity(ActivityRequest activityRequest) {
		
		Activity activity = new Activity();
		
		activity.setUserId(activityRequest.getUserId());
		activity.setType(activityRequest.getType());
		activity.setDuration(activityRequest.getDuration());
		activity.setCaloriesBurn(activityRequest.getCaloriesBurn());
		activity.setStartTime(activityRequest.getStartTime());
		activity.setAdditionalMetrics(activityRequest.getAdditionalMetrics());
		
		return activity;
	}
	

}
