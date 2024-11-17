package com.skillconnect.service;

import com.skillconnect.model.Recommendation;
import com.skillconnect.repository.RecommendationRepository;
import com.skillconnect.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Override
    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    @Override
    public Optional<Recommendation> getRecommendationById(int id) {
        return recommendationRepository.findById(id);
    }

    @Override
    public Recommendation saveRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    @Override
    public void deleteRecommendation(int id) {
        recommendationRepository.deleteById(id);
    }
}
