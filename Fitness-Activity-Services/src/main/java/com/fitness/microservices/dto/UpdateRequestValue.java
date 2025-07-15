package com.fitness.microservices.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.fitness.microservices.model.Activity;
import com.fitness.microservices.model.ActivityType;

import lombok.Data;

@Data
public class UpdateRequestValue {
	private String userId;
	private ActivityType type;
	private Integer duration;
	private Integer caloriesBurn;
	private LocalDateTime startTime;
	private Map<String, Object> additionalMetrics;
	
	public static Activity convertUpdateRequestValueToActivity(UpdateRequestValue updateRequestValue) {
		
		Activity activity = new Activity();
		
		activity.setUserId(updateRequestValue.getUserId());
		activity.setType(updateRequestValue.getType());
		activity.setDuration(updateRequestValue.getDuration());
		activity.setCaloriesBurn(updateRequestValue.getCaloriesBurn());
		activity.setStartTime(updateRequestValue.getStartTime());
		activity.setAdditionalMetrics(updateRequestValue.getAdditionalMetrics());
		
		return activity;
	}

}
