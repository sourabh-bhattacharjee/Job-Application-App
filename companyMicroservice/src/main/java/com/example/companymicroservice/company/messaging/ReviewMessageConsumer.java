package com.example.companymicroservice.company.messaging;

import com.example.companymicroservice.company.CompanyService;
import com.example.companymicroservice.company.dto.ReviewMessageDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReviewMessageConsumer {

    private final CompanyService companyService;

    @RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewMessageDto reviewMessageDto){
        System.out.println("Received Message from RabbitMQ");
        companyService.updateCompanyRating(reviewMessageDto);
    }
}
