package com.example.jobapplication.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "jobs")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    private String id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

}
