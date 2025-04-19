package com.example.miniapp.repositories;

import com.example.miniapp.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {
    
    // Custom Query using @Query (JPQL)
    @Query("SELECT c FROM Captain c WHERE c.avgRatingScore > :ratingThreshold")
    List<Captain> getCaptainsWithRatingAbove(@Param("ratingThreshold") Double ratingThreshold);

    @Query("SELECT c FROM Captain c WHERE c.licenseNumber = :licenseNumber")
    Optional<Captain> getCaptainByLicenseNumber(@Param("licenseNumber") String licenseNumber);
}
