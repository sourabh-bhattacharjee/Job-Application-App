package com.example.reviewmicroservice.reviews;

import lombok.Data;

@Data
public class ReviewClientDto {
    private String description;
    private Double rating;
    private String title;
}
