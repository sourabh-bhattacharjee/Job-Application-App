package com.example.jobmicroservice.job;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JobRepository extends MongoRepository<Job, String> {

    List<Job> findByCompanyId(String companyId);

    List<Job> findAllByCompanyId(String companyId);

    void deleteAllByCompanyId(String companyId);
}
