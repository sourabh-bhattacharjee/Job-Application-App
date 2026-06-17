package com.example.reviewmicroservice.reviews.impl;

import com.example.jobapplication.company.Company;
import com.example.jobapplication.company.CompanyRepository;
import com.example.jobapplication.reviews.Review;
import com.example.jobapplication.reviews.ReviewDto;
import com.example.jobapplication.reviews.ReviewRepository;
import com.example.jobapplication.reviews.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyRepository companyRepository;

    @Override
    public List<Review> getAllReviewsOfCompany(String id) {
        return reviewRepository.getAllByCompanyId(id);
    }

    @Override
    public Review createReview(String id, ReviewDto reviewDto) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found with id"+id));
        Review review = Review.builder()
                .companyId(company.getId())
                .review(reviewDto.getReview())
                .build();
        return reviewRepository.save(review);
    }

    @Override
    public Review getReview(String id, String reviewId) {
        return reviewRepository.getByCompanyIdAndId(id,reviewId).orElseThrow(() -> new RuntimeException("Review not Found"));
    }

    @Override
    public Review updateReview(String id, String reviewId, ReviewDto reviewDto) {
        Review review = reviewRepository.getByCompanyIdAndId(id,reviewId).orElseThrow(() -> new RuntimeException("Review not Found"));
        review.setReview(reviewDto.getReview());
        return reviewRepository.save(review);
    }

    @Override
    public Review deleteReview(String id, String reviewId) {
        Review review =  reviewRepository.getByCompanyIdAndId(id,reviewId).orElseThrow(() -> new RuntimeException("Review not Found"));
        reviewRepository.delete(review);
        return review;
    }

}
