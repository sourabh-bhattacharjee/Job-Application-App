package com.example.companymicroservice.company.client;

import com.example.companymicroservice.company.dto.JobDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClient;

import java.util.List;

@FeignClient(name = "JOBMICROSERVICE")
public interface JobClient {

    @DeleteMapping("/jobs/{id}/deleteAll")
    void deleteAllByCompanyId(@PathVariable String id);

    @GetMapping("/jobs/{id}/findAll")
    List<JobDto>findAllByCompanyId(@PathVariable String id);
}
