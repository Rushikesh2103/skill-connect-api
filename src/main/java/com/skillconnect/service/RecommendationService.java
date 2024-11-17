package com.skillconnect.service;

import com.skillconnect.model.Recommendation;
import java.util.List;
import java.util.Optional;

public interface RecommendationService {
    List<Recommendation> getAllRecommendations();
    Optional<Recommendation> getRecommendationById(int id);
    Recommendation saveRecommendation(Recommendation recommendation);
    void deleteRecommendation(int id);
}
