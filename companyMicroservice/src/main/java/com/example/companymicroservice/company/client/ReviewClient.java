package com.example.companymicroservice.company.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="REVIEWMICROSERVICE",
                url = "${REVIEWMICROSERVICE.url}")
public interface ReviewClient {

    @DeleteMapping("/company/{id}/reviews/deleteAll")
    void deleteAllByCompanyId(@PathVariable String id);

    @GetMapping("/company/{id}/reviews/averageRating")
    Double getAverageRatingOfReviews(@PathVariable String id);
}
