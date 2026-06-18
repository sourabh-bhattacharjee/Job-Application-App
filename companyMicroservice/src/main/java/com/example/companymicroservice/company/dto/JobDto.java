package com.example.companymicroservice.company.dto;

import lombok.Data;

@Data
public class JobDto {
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
}
