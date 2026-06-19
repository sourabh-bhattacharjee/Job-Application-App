package com.example.jobmicroservice.job;

import com.example.jobmicroservice.job.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CompanyClient {

    private final RestClient companyServiceRestClient;

    public CompanyDto findByName(String name){
        return companyServiceRestClient.get()
                .uri("/companies/{name}/name", name)
                .retrieve()
                .body(CompanyDto.class);
    }

}
