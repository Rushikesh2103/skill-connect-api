package com.skillconnect.service;

import com.skillconnect.model.Review;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReviews();
    Optional<Review> getReviewById(int id);
    Review saveReview(Review review);
    void deleteReview(int id);
}
