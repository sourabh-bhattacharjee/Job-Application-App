package com.example.jobmicroservice.job.client;

import com.example.jobmicroservice.job.dto.CompanyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANYMICROSERVICE" ,
        url= "${COMPANYMICROSERVICE.url}")
public interface CompanyClient {

    @GetMapping("/companies/{name}/name")
    CompanyDto findByName(@PathVariable String name);
}
