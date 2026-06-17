package com.example.reviewmicroservice.reviews;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "review")
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    private String id;

    private String review;

    @NonNull
    private String companyId;
}
