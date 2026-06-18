package com.example.reviewmicroservice.reviews.impl;
import com.example.reviewmicroservice.reviews.*;
import com.example.reviewmicroservice.reviews.dto.CompanyDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyClient companyClient;

    @Override
    public List<Review> getAllReviewsOfCompany(String id) {
        return reviewRepository.getAllByCompanyId(id);
    }

    @Override
    public Review createReview(String id, ReviewClientDto reviewDto) {
        CompanyDto company = companyClient.getCompanyById(id);
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
    public Review updateReview(String id, String reviewId, ReviewClientDto reviewDto) {
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
