package com.example.reviewmicroservice.reviews;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
@Configuration
class RestClientConfig {
    @Bean
    public RestClient companyRestClient(){
        return RestClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }
}