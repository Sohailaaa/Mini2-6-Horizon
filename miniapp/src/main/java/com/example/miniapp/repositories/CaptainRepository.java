package com.example.miniapp.repositories;

import com.example.miniapp.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//• Query to find all captains with a rating above a threshold.
//• Query to locate a captain by license number.
@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {

    List<Captain> findByAvgRatingScoreGreaterThan(Double ratingThreshold);

    Optional<Captain> findByLicenseNumber(String licenseNumber);
}
