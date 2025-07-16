package com.fitness.aigeminiservice.controller;

import com.fitness.aigeminiservice.module.Recommendation;
import com.fitness.aigeminiservice.services.RecommendationServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationServices recommendationServices;

    @GetMapping
    public List<Recommendation> getAllRecommendations() {
        return recommendationServices.getAllRecommendations();
    }

    @GetMapping("/user/{userId}")
    public List<Recommendation> getRecommendationsByUserId(@PathVariable String userId) {
        return recommendationServices.getRecommendationByUserId(userId);
    }

    @GetMapping("/activity/{activityId}")
    public Recommendation getRecommendationsByActivityId(@PathVariable String activityId) {
        return recommendationServices.getRecommendationByActivityId(activityId);
    }

    @PostMapping
    public Recommendation createRecommendation(@RequestBody Recommendation recommendation) {
        return recommendationServices.createRecommendation(recommendation);
    }

    @GetMapping("/{id}")
    public Recommendation getRecommendationById(@PathVariable String id) {
        return recommendationServices.getRecommendationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRecommendation(@PathVariable String id) {
        recommendationServices.deleteRecommendation(id);
    }

    @PutMapping("/{id}")
    public Recommendation updateRecommendation(@PathVariable String id, @RequestBody Recommendation updatedRecommendation) {
        return recommendationServices.updateRecommendation(id, updatedRecommendation);
    }



}
