package com.fitness.microservices.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.microservices.dto.ActivityRequest;
import com.fitness.microservices.dto.ActivityResponse;
import com.fitness.microservices.dto.UpdateRequestValue;
import com.fitness.microservices.model.Activity;
import com.fitness.microservices.repository.ActivityRepository;
import com.fitness.microservices.services.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	private ActivityRepository activityRepository;
	

	@Override
	public boolean exitByUserId(String userId) {
		return activityRepository.existsByUserId(userId);
	}

	@Override
	public ActivityResponse getActivityByUserId(String userId) {
		
		return ActivityResponse.convertActivityToActivityResponse(activityRepository.findByUserId(userId).get());
	}
	
	

	@Override
	public List<ActivityResponse> getAll() {
		
		return activityRepository
				.findAll()
				.stream()
				.map(activity -> ActivityResponse.convertActivityToActivityResponse(activity))
				.collect(Collectors.toList());
	}

	@Override
	public ActivityResponse postActivity(ActivityRequest activityRequest) {
		
		
		return ActivityResponse
				.convertActivityToActivityResponse(
						activityRepository.save(
								ActivityRequest.convertActivityRequestToActivity(activityRequest)
								)
						);
	}

	@Override
	public ActivityResponse putActivity(UpdateRequestValue updateRequestValue) {
		Activity activity = activityRepository.findByUserId(updateRequestValue.getUserId()).get();
		activity.setUserId(updateRequestValue.getUserId());
		activity.setType(updateRequestValue.getType());
		activity.setDuration(updateRequestValue.getDuration());
		activity.setCalouiesBurn(updateRequestValue.getCalouiesBurn());
		activity.setStartTime(updateRequestValue.getStartTime());
		activity.setAdditionalMetrics(updateRequestValue.getAdditionalMetrics());
		return ActivityResponse
				.convertActivityToActivityResponse(
						activityRepository.save(
								activity
								)
						);
	}

	@Override
	public void deleteActivityByuserId(String userId) {
		activityRepository.deleteByUserId(userId);
		
	}




}
