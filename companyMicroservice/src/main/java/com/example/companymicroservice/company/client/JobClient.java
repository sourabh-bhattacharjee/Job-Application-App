package com.example.companymicroservice.company.client;

import com.example.companymicroservice.company.dto.JobDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class JobClient {
    private final RestClient restClient;
    public JobClient(@LoadBalanced RestClient.Builder builder){
        this.restClient = builder.baseUrl("""
                http://JOBMICROSERVICE""").build();
    }

    public void deleteAllByCompanyId(String id) {
        restClient.delete().uri("/jobs/{id}/deleteAll").retrieve().toBodilessEntity();
    }

    public List<JobDto> findAllByCompanyId(String id) {

        return restClient.get().uri("/jobs/{id}/findAll",id)
                .retrieve()
                .body(new ParameterizedTypeReference<List<JobDto>>() {});
    }
}
