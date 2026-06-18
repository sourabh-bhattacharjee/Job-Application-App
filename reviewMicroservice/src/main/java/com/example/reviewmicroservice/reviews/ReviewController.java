package com.example.reviewmicroservice.reviews;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/companies/{id}/reviews")
public class ReviewController {


    private ReviewService reviewService;

    //get all reviews for a company
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviewsOfCompany(@PathVariable String id){
        List<Review> reviews = reviewService.getAllReviewsOfCompany(id);
        return reviews.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(reviews,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@PathVariable String id, @RequestBody ReviewClientDto reviewDto){
        return new ResponseEntity<>(reviewService.createReview(id,reviewDto),HttpStatus.CREATED);
    }

    // get reviews by id for the specific company
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable String id, @PathVariable String reviewId){
        return new ResponseEntity<>(reviewService.getReview(id,reviewId),HttpStatus.OK);
    }

    // update the review
    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReviewById(@PathVariable String id, @PathVariable String reviewId, @RequestBody ReviewClientDto reviewDto){
        return new ResponseEntity<>(reviewService.updateReview(id,reviewId,reviewDto),HttpStatus.OK);
    }


    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Review> deleteReviewById(@PathVariable String id, @PathVariable String reviewId){
        return new ResponseEntity<>(reviewService.deleteReview(id,reviewId),HttpStatus.OK);
    }







}
