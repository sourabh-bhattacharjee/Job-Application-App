package com.example.reviewmicroservice.reviews;

import com.example.reviewmicroservice.reviews.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClient;

@FeignClient(name = "COMPANYMICROSERVICE" ,
        url= "${COMPANYMICROSERVICE.url}")
public interface CompanyClient {
    @GetMapping("/companies/{id}")
    CompanyDto getCompanyById(@PathVariable String id);
}
