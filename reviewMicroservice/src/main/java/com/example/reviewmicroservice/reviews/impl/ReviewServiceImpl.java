package com.example.reviewmicroservice.reviews.impl;
import com.example.reviewmicroservice.reviews.*;
import com.example.reviewmicroservice.reviews.dto.CompanyDto;
import com.example.reviewmicroservice.reviews.messaging.ReviewMessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyClient companyClient;
    private ReviewMessageProducer reviewMessageProducer;

    @Override
    public List<Review> getAllReviewsOfCompany(String id) {
        return reviewRepository.getAllByCompanyId(id);
    }

    @Override
    public Review createReview(String id, ReviewClientDto reviewDto) {
        CompanyDto company = companyClient.getCompanyById(id);
        Review review = Review.builder()
                .companyId(company.getId())
                .description(reviewDto.getDescription())
                .rating(reviewDto.getRating())
                .title(reviewDto.getTitle())
                .build();
        Review savedReview = reviewRepository.save(review);
        reviewMessageProducer.sendMessage(savedReview);
        return savedReview;
    }

    @Override
    public Review getReview(String id, String reviewId) {
        return reviewRepository.getByCompanyIdAndId(id,reviewId).orElseThrow(() -> new RuntimeException("Review not Found"));
    }

    @Override
    public Review updateReview(String id, String reviewId, ReviewClientDto reviewDto) {
        Review review = reviewRepository.getByCompanyIdAndId(id,reviewId).orElseThrow(() -> new RuntimeException("Review not Found"));
        review.setDescription(reviewDto.getDescription());
        return reviewRepository.save(review);
    }

    @Override
    public Review deleteReview(String id, String reviewId) {
        Review review =  reviewRepository.getByCompanyIdAndId(id,reviewId).orElseThrow(() -> new RuntimeException("Review not Found"));
        reviewRepository.delete(review);
        return review;
    }

    @Override
    public void deleteAllReviewsOfCompany(String id) {
        reviewRepository.deleteAllByCompanyId(id);
    }

}
