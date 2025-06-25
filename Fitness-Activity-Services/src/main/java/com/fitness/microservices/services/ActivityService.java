package com.fitness.microservices.services;

import java.util.List;

import com.fitness.microservices.dto.ActivityRequest;
import com.fitness.microservices.dto.ActivityResponse;
import com.fitness.microservices.dto.UpdateRequestValue;

public interface ActivityService {
	
		public boolean exitByUserId(String userId);

		public ActivityResponse getActivityByUserId(String userId);
		
		public List<ActivityResponse> getAll();
		
		public ActivityResponse postActivity(ActivityRequest activityRequest);
		
		public ActivityResponse putActivity(UpdateRequestValue updateRequestValue);
		
		public void deleteActivityByuserId(String userId);
}
