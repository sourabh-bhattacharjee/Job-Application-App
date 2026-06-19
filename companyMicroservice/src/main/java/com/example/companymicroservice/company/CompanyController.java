package com.example.companymicroservice.company;

import com.example.companymicroservice.company.dto.JobDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@AllArgsConstructor
public class CompanyController {
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompaniesById(@PathVariable String id){
        if(companyService.getCompaniesById(id) != null){
            return new ResponseEntity<>(companyService.getCompaniesById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company ){
        return new ResponseEntity<>(companyService.createCompany(company),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCompany(@PathVariable String id, @RequestBody Company company){
        companyService.updateCompanyById(id,company);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable String id){
        companyService.deleteCompany(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/jobs")
    public ResponseEntity<List<JobDto>> getAllJobsFromCompany(@PathVariable String id){
        List<JobDto> jobs = companyService.getAllJobsFromCompany(id);
        if(jobs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/{name}/name")
    public ResponseEntity<Company> getCompanyName(@PathVariable String name){
        return new ResponseEntity<>(companyService.getCompanyName(name), HttpStatus.OK);
    }

}
