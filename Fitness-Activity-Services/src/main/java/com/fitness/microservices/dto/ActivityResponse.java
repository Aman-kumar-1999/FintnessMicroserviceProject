package com.fitness.microservices.dto;

import java.time.LocalDateTime;
import java.util.Map;



import com.fitness.microservices.model.Activity;
import com.fitness.microservices.model.ActivityType;

import lombok.Data;

@Data
public class ActivityResponse {
	
	private String id;
	private String userId;
	private ActivityType type;
	private Integer duration;
	private Integer caloriesBurn;
	private LocalDateTime startTime;
	private Map<String,Object> additionalMetrics;	
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	public static Activity convertActivityResponseToActivity(ActivityResponse activityResponse) {
		Activity activity = new Activity();
		
		activity.setId(activityResponse.getId());
		activity.setUserId(activityResponse.getUserId());
		activity.setType(activityResponse.getType());
		activity.setDuration(activityResponse.getDuration());
		activity.setCaloriesBurn(activityResponse.getCaloriesBurn());
		activity.setStartTime(activityResponse.getStartTime());
		activity.setAdditionalMetrics(activityResponse.getAdditionalMetrics());
		activity.setCreateAt(activityResponse.getCreateAt());
		activity.setUpdateAt(activityResponse.getUpdateAt());
		
		return activity;
	}
	
	public static ActivityResponse convertActivityToActivityResponse(Activity activity) {
		ActivityResponse activityResponse = new ActivityResponse();
		
		activityResponse.setId(activity.getId());
		activityResponse.setUserId(activity.getUserId());
		activityResponse.setType(activity.getType());
		activityResponse.setDuration(activity.getDuration());
		activityResponse.setCaloriesBurn(activity.getCaloriesBurn());
		activityResponse.setStartTime(activity.getStartTime());
		activityResponse.setAdditionalMetrics(activity.getAdditionalMetrics());
		activityResponse.setCreateAt(activity.getCreateAt());
		activityResponse.setUpdateAt(activity.getUpdateAt());
		
		return activityResponse;
	}

}
