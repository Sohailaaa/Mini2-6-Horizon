package com.example.miniapp.repositories;

import com.example.miniapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query("SELECT t FROM Trip t WHERE t.tripDate BETWEEN :startDate AND :endDate")
    List<Trip> findByTripDateBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT t FROM Trip t WHERE t.captain.id = :captainId")
    List<Trip> findByCaptainId(@Param("captainId") Long captainId);
}