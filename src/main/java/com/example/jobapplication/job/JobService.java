package com.example.jobapplication.job;

import org.bson.types.ObjectId;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(JobWithCompanyName jobWithCompanyName);

    Job getJobById(String id);

    boolean deleteJob(String id);

    boolean updateJob(String id, Job updatedJob);
}
