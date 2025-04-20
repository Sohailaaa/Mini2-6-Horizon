package com.example.miniapp.repositories;

import com.example.miniapp.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// • Finding payments by trip ID.
//• Finding payments with an amount above a set threshold.


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT p FROM Payment p WHERE p.trip.id = :tripId")
    List<Payment> findByTripId(@Param("tripId") Long tripId);

    @Query("SELECT p FROM Payment p WHERE p.amount > :amountThreshold")
    List<Payment> findByAmountGreaterThan(@Param("amountThreshold") Double amountThreshold);
}
