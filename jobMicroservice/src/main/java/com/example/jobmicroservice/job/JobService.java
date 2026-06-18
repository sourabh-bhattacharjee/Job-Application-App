package com.example.jobmicroservice.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(JobWithCompanyName jobWithCompanyName);

    Job getJobById(String id);

    boolean deleteJob(String id);

    boolean updateJob(String id, Job updatedJob);

    void deleteAllJobByCompany(String id);
}
