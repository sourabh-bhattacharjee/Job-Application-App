package com.example.companymicroservice.company.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="REVIEWMICROSERVICE")
public interface ReviewClient {

    @DeleteMapping("/reviews/{id}/deleteAll")
    void deleteAllByCompanyId(@PathVariable String id);
}
