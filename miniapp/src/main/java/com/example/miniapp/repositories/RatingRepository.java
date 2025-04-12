package com.example.miniapp.repositories;

import com.example.miniapp.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//    • Find ratings for a given entity (by ID and type).
//    • Retrieve ratings with a score above a specified value

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

//    List<Rating> findByEntityIdAndEntityType(Long entityId, String entityType);
//
//    List<Rating> findByScoreGreaterThan(Integer score);
}
