package com.example.companymicroservice.company.client;

import com.example.companymicroservice.company.dto.JobDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class JobClient {
    private final RestClient restClient;
    public JobClient(@Qualifier("jobServiceRestClient") RestClient restClient){
        this.restClient = restClient;
    }

    public void deleteAllByCompanyId(String id) {
        restClient.delete().uri("/jobs/{id}/deleteAll").retrieve().toBodilessEntity();
    }

    public List<JobDto> findAllByCompanyId(String id) {

        return restClient.get().uri("/jobs/{id}/findAll")
                .retrieve()
                .body(new ParameterizedTypeReference<List<JobDto>>() {});
    }
}
