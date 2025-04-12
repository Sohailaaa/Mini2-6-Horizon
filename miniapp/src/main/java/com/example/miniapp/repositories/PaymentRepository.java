package com.example.miniapp.repositories;

import com.example.miniapp.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// • Finding payments by trip ID.
//• Finding payments with an amount above a set threshold.


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

//    Optional<Payment> findByTripId(Long tripId);
//
//    List<Payment> findByAmountGreaterThan(Double amountThreshold);
}
