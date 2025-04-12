package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        return null;
    }

    public Rating updateRating(String id, Rating updatedRating) {
        return null;
    }

    public void deleteRating(String id) {
    }

    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return null;
    }

    public List<Rating> findRatingsAboveScore(int minScore) {
        return null;
    }

}