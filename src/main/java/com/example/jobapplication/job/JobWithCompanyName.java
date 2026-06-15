package com.example.jobapplication.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class JobWithCompanyName {
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private String companyName;
}
