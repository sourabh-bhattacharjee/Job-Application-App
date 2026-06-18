package com.example.companymicroservice.company.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ReviewClient {
    private final RestClient restClient;
    public ReviewClient(@Qualifier("reviewServiceRestClient") RestClient restClient){
        this.restClient = restClient;
    }
    public void deleteAllByCompanyId(String id) {
        restClient.delete().uri("/reviews/{id}/deleteAll").retrieve().toBodilessEntity();
    }
}
