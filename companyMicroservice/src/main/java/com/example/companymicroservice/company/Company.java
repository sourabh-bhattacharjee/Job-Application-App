package com.example.companymicroservice.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "companies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    private String id;
    private String name;
    private String description;


}
