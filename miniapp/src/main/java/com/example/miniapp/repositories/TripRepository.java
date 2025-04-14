package com.example.miniapp.repositories;

import com.example.miniapp.models.Payment;
import com.example.miniapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query(value = "SELECT * FROM trips WHERE trip_date BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Trip> findByTripDateBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query(value = "SELECT * FROM trips WHERE captain_id = :captainId", nativeQuery = true)
    List<Trip> findByCaptainId(@Param("captainId") Long captainId);
}
