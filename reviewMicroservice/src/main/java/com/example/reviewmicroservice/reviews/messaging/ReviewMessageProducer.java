package com.example.reviewmicroservice.reviews.messaging;

import com.example.reviewmicroservice.reviews.Review;
import com.example.reviewmicroservice.reviews.dto.ReviewMessageDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewMessageProducer {

    private final RabbitTemplate rabbitTemplate;
    public void sendMessage(Review review){

        ReviewMessageDto reviewMessageDto = new ReviewMessageDto();
        reviewMessageDto.setId(review.getId());
        reviewMessageDto.setRating(review.getRating());
        reviewMessageDto.setTitle(review.getTitle());
        reviewMessageDto.setDescription(review.getDescription());
        reviewMessageDto.setCompanyId(review.getCompanyId());

        rabbitTemplate.convertAndSend("companyRatingQueue", reviewMessageDto);
    }
}
