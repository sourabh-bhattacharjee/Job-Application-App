package com.example.jobapplication.company;

import com.example.jobapplication.job.Job;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company createCompany(Company company);

    Company getCompaniesById(String id);

    void updateCompanyById(String id, Company company);

    void deleteCompany(String id);

    List<Job> getAllJobsFromCompany(String id);
}
