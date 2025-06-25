package com.fitness.microservices.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.microservices.dto.ActivityRequest;
import com.fitness.microservices.dto.UpdateRequestValue;
import com.fitness.microservices.services.ActivityService;

@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(activityService.getAll());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Map<String,Object>> getActivity(@PathVariable String userId){
		Map<String,Object> map = new HashMap<>();
		
		try {
			
			if(activityService.exitByUserId(userId)) {
				map.put("STATUS","SUCCESS" );
				map.put("DATA", activityService.getActivityByUserId(userId));
			}else {
				map.put("STATUS", "FAILED");
				map.put("MESSAGE", "This given UserId is not persent");
			}
			//map.put("DATA", map);
		} catch (Exception e) {
			map.put("STATUS", "FAILED");
			map.put("MESSAGE", e.getMessage());
			e.printStackTrace();
		}
		
		
		
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/")
	public ResponseEntity<Map<String,Object>> createActivity(@RequestBody ActivityRequest activityRequest){
		Map<String,Object> map = new HashMap<>();
		
		try {
			
			if(activityService.exitByUserId(activityRequest.getUserId())) {
				map.put("STATUS", "FAILED");
				map.put("MESSAGE", "This given UserId is already persent");
			}else {
				map.put("STATUS","SUCCESS" );
				map.put("DATA", activityService.postActivity(activityRequest));
			}
			//map.put("DATA", map);
		} catch (Exception e) {
			map.put("STATUS", "FAILED");
			map.put("MESSAGE", e.getMessage());
			e.printStackTrace();
		}
		
		
		
		return ResponseEntity.ok(map);
	}
	
	@PutMapping("/")
	public ResponseEntity<Map<String,Object>> updateActivity(@RequestBody UpdateRequestValue updateRequestValue){
		Map<String,Object> map = new HashMap<>();
		
		try {
			
			if(activityService.exitByUserId(updateRequestValue.getUserId())) {
				map.put("STATUS","SUCCESS" );
				map.put("DATA", activityService.putActivity(updateRequestValue));
			}else {
				map.put("STATUS", "FAILED");
				map.put("MESSAGE", "This given UserId is not persent");
			}
			//map.put("DATA", map);
		} catch (Exception e) {
			map.put("STATUS", "FAILED");
			map.put("MESSAGE", e.getMessage());
			e.printStackTrace();
		}
		
		
		
		return ResponseEntity.ok(map);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Map<String,Object>> deleteActivity(@PathVariable String userId){
		Map<String,Object> map = new HashMap<>();
		
		try {
			
			if(activityService.exitByUserId(userId)) {
				map.put("STATUS","SUCCESS" );
				activityService.deleteActivityByuserId(userId);
				map.put("MESSAGE", "The given userId : "+userId+" data has been deleted");
			}else {
				map.put("STATUS", "FAILED");
				map.put("MESSAGE", "This given UserId is not persent");
			}
			//map.put("DATA", map);
		} catch (Exception e) {
			map.put("STATUS", "FAILED");
			map.put("MESSAGE", e.getMessage());
			e.printStackTrace();
		}
		
		
		
		return ResponseEntity.ok(map);
	}


}
