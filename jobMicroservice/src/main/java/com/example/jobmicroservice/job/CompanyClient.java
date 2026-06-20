package com.example.jobmicroservice.job;

import com.example.jobmicroservice.job.dto.CompanyDto;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CompanyClient {

    private final RestClient companyServiceRestClient;

    public CompanyClient(@LoadBalanced RestClient.Builder builder){
        this.companyServiceRestClient = builder.baseUrl("http://REVIEWMICROSERVICE").build();
    }
    public CompanyDto findByName(String name){
        return companyServiceRestClient.get()
                .uri("/companies/{name}/name", name)
                .retrieve()
                .body(CompanyDto.class);
    }

}
