package com.example.companymicroservice.company;

import com.example.companymicroservice.company.dto.JobDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company createCompany(Company company);

    Company getCompaniesById(String id);

    void updateCompanyById(String id, Company company);

    void deleteCompany(String id);

    List<JobDto> getAllJobsFromCompany(String id);

    Company getCompanyName(String name);
}
