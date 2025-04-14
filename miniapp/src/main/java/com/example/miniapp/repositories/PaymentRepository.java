package com.example.miniapp.repositories;

import com.example.miniapp.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// • Finding payments by trip ID.
//• Finding payments with an amount above a set threshold.


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query(value = "SELECT * FROM payments WHERE trip_id = :tripId", nativeQuery = true)
    List<Payment> findByTripId(Long tripId);

    @Query(value = "SELECT * FROM payments WHERE amount > :amountThreshold", nativeQuery = true)
    List<Payment> findByAmountGreaterThan(Double amountThreshold);
}
