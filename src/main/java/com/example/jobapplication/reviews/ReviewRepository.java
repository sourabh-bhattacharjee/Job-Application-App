package com.example.jobapplication.reviews;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends MongoRepository<Review,String> {
    List<Review> getAllByCompanyId(String companyId);

    Optional<Review> getByCompanyIdAndId(String id, String reviewId);

    void deleteAllByCompanyId(String companyId);
}
