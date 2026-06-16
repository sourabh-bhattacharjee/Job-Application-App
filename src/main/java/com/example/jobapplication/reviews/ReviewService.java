package com.example.jobapplication.reviews;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsOfCompany(String id);

    Review createReview(String id, ReviewDto reviewDto);

    Review getReview(String id, String reviewId);

    Review updateReview(String id, String reviewId, ReviewDto reviewDto);

    Review deleteReview(String id, String reviewId);
}
