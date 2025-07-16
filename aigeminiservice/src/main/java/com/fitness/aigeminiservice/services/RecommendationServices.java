package com.fitness.aigeminiservice.services;

import com.fitness.aigeminiservice.module.Recommendation;
import com.fitness.aigeminiservice.repo.RecommendationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationServices {

    private final RecommendationRepo recommendationRepo;

    public List<Recommendation> getAllRecommendations() {
        return recommendationRepo.findAll();
    }

    public Recommendation createRecommendation(Recommendation recommendation) {
        return recommendationRepo.save(recommendation);
    }

    public Recommendation getRecommendationById(String id) {
        return recommendationRepo.findById(id).orElse(null);
    }

    public void deleteRecommendation(String id) {
        recommendationRepo.deleteById(id);
    }

    public Recommendation updateRecommendation(String id, Recommendation updatedRecommendation) {
        return recommendationRepo.findById(id)
                .map(existing -> {
                    existing.setActivityId(updatedRecommendation.getActivityId());
                    existing.setUserId(updatedRecommendation.getUserId());
                    existing.setActivityType(updatedRecommendation.getActivityType());
                    existing.setRecommendation(updatedRecommendation.getRecommendation());
                    existing.setImprovements(updatedRecommendation.getImprovements());
                    existing.setSuggestions(updatedRecommendation.getSuggestions());
                    existing.setSafety(updatedRecommendation.getSafety());
                    return recommendationRepo.save(existing);
                })
                .orElse(null);
    }

    public List<Recommendation> getRecommendationByUserId(String userId) {
        return recommendationRepo.findByUserId(userId);

    }

    public Recommendation getRecommendationByActivityId(String activityId) {
        return recommendationRepo.findByActivityId(activityId).orElseThrow(() -> new RuntimeException("Recommendation not found for activityId: " + activityId));
    }
}
