package com.example.reviewmicroservice.reviews;

import com.example.reviewmicroservice.reviews.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CompanyClient {
    private final RestClient companyRestClient;
    public CompanyDto getCompanyById(String id){
        return companyRestClient.get()
                .uri("/companies/{id}", id)
                .retrieve()
                .body(CompanyDto.class);
    }
}
