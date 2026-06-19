package com.example.jobmicroservice.job.impl;

import com.example.jobmicroservice.job.*;
import com.example.jobmicroservice.job.dto.CompanyDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
    private CompanyClient companyClient;


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(JobWithCompanyName jobWithCompanyName) {
        CompanyDto company = companyClient.findByName(jobWithCompanyName.getCompanyName());
        if(company==null){
            throw new RuntimeException("Company not found");
        }
        String companyId = company.getId();
        Job job = Job.builder()
                        .title(jobWithCompanyName.getTitle())
                                .description(jobWithCompanyName.getDescription())
                                        .maxSalary(jobWithCompanyName.getMaxSalary())
                                                .minSalary(jobWithCompanyName.getMinSalary())
                                                        .location(jobWithCompanyName.getLocation())
                                                                .companyId(companyId).build();
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(String id) {
        List<Job> jobs = jobRepository.findAll();
        for(Job job:jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }

        return null;
    }

    @Override
    public boolean deleteJob(String id) {
        if(jobRepository.existsById(id)){
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllJobByCompany(String id) {
        jobRepository.deleteAllByCompanyId(id);
    }

    @Override
    public List<Job> findAllByCompanyId(String id) {
         return jobRepository.findAllByCompanyId(id);
    }

    @Override
    public boolean updateJob(String id, Job updatedJob) {

        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){

            Job job = jobOptional.get();

            job.setLocation(updatedJob.getLocation());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            jobRepository.save(job);
            return true;
        }
        return false;

    }
}
