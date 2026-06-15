package com.example.jobapplication.company.impl;

import com.example.jobapplication.company.Company;
import com.example.jobapplication.company.CompanyRepository;
import com.example.jobapplication.company.CompanyService;
import com.example.jobapplication.job.Job;
import com.example.jobapplication.job.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private JobRepository jobRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll() ;
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompaniesById(String id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        return companyOptional.orElse(null);
    }

    @Override
    public void updateCompanyById(String id, Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company1 = companyOptional.get();
            company1.setName(company.getName());
            company1.setDescription(company.getDescription());
            companyRepository.save(company1);
        }
    }

    @Override
    public void deleteCompany(String id) {
        companyRepository.findById(id).ifPresent(company -> companyRepository.delete(company));
    }

    @Override
    public List<Job> getAllJobsFromCompany(String id) {
        List<Job> jobs =  jobRepository.findAllByCompanyId(id);
        if(jobs.isEmpty()){
            throw new RuntimeException("Company not found with Id : "+ id);
        }
        return jobs;
    }
}
