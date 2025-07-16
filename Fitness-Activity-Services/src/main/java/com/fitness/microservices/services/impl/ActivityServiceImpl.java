package com.fitness.microservices.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.fitness.microservices.services.UserServices;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Autowired
	private UserServices userServices;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;

	@Value("${rabbitmq.routing-key}")
	private String routingKey;

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
				.map(ActivityResponse::convertActivityToActivityResponse)
				.collect(Collectors.toList());
	}

	@Override
	public ActivityResponse postActivity(ActivityRequest activityRequest) {

		if (!userServices.validate(activityRequest.getUserId())){
			throw new RuntimeException("User not found: " + activityRequest.getUserId());
		}

		ActivityResponse activityResponse =  ActivityResponse
				.convertActivityToActivityResponse(
						activityRepository.save(
								ActivityRequest.convertActivityRequestToActivity(activityRequest)
						)
				);

		// Send activity to RabbitMQ PUBLISHER (Publish the activity to the exchange)

		try{
			rabbitTemplate.convertAndSend(exchangeName, routingKey, activityResponse);
		} catch (Exception e) {
			throw new RuntimeException("Failed to send activity to RabbitMQ: " + e.getMessage());
		}

		return activityResponse;
	}

	@Override
	public ActivityResponse putActivity(UpdateRequestValue updateRequestValue) {
		Activity activity = activityRepository.findByUserId(updateRequestValue.getUserId()).get();
		activity.setUserId(updateRequestValue.getUserId());
		activity.setType(updateRequestValue.getType());
		activity.setDuration(updateRequestValue.getDuration());
		activity.setCaloriesBurn(updateRequestValue.getCaloriesBurn());
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
