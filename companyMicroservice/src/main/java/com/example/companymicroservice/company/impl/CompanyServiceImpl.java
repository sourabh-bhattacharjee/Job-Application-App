package com.example.companymicroservice.company.impl;

import com.example.companymicroservice.company.CompanyService;
import com.example.companymicroservice.company.Company;
import com.example.companymicroservice.company.CompanyRepository;
import com.example.companymicroservice.company.client.JobClient;
import com.example.companymicroservice.company.client.ReviewClient;
import com.example.companymicroservice.company.dto.JobDto;
import com.example.companymicroservice.company.dto.ReviewMessageDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private JobClient jobClient;
    private ReviewClient reviewClient;

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
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        reviewClient.deleteAllByCompanyId(id);
        jobClient.deleteAllByCompanyId(id);
        companyRepository.delete(company);
    }

    @Override
    public List<JobDto> getAllJobsFromCompany(String id) {

        return jobClient.findAllByCompanyId(id);
    }

    @Override
    public Company getCompanyName(String name) {
        return companyRepository.findByName(name);
    }

    @Override
    public void updateCompanyRating(ReviewMessageDto reviewMessageDto) {
        Double rating = reviewClient.getAverageRatingOfReviews(reviewMessageDto.getCompanyId());

        System.out.println(rating);
        Company company = companyRepository.findById(reviewMessageDto.getCompanyId()).orElseThrow(() -> new RuntimeException("Company not found"));
        company.setRating(rating);
        companyRepository.save(company);

    }
}
