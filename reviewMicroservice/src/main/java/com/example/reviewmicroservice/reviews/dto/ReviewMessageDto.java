package com.example.reviewmicroservice.reviews.dto;

import lombok.Data;

@Data
public class ReviewMessageDto {
    private String id;
    private String title;
    private String description;
    private double rating;
    private String companyId;

}
