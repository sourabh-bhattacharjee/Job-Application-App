package com.example.companymicroservice.company;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient jobServiceRestClient(){
        return RestClient.builder()
                .baseUrl("http://localhost:8082")
                .build();
    }

    @Bean
    public RestClient reviewServiceRestClient(){
        return RestClient.builder()
                .baseUrl("http://localhost:8083")
                .build();
    }
}
