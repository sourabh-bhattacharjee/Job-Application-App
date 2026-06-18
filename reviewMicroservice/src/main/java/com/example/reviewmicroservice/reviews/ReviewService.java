package com.example.reviewmicroservice.reviews;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsOfCompany(String id);

    Review createReview(String id, ReviewClientDto reviewDto);

    Review getReview(String id, String reviewId);

    Review updateReview(String id, String reviewId, ReviewClientDto reviewDto);

    Review deleteReview(String id, String reviewId);
}
