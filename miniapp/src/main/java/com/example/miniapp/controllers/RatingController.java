package com.example.miniapp.controllers;

import com.example.miniapp.models.Rating;
import com.example.miniapp.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/addRating")
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }

    @PutMapping("/update/{id}")
    public Rating updateRating(@PathVariable String id, @RequestBody Rating updatedRating) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRating(@PathVariable String id) {
        return null;
    }

    @GetMapping("/findByEntity")
    public List<Rating> findRatingsByEntity(@RequestParam Long entityId, @RequestParam String
            entityType) {
        return null;
    }

    @GetMapping("/findAboveScore")
    public List<Rating> findRatingsAboveScore(@RequestParam int minScore) {
        return null;
    }

}