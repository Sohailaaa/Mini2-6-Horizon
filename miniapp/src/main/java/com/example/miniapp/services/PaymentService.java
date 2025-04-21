package com.example.miniapp.services;

import com.example.miniapp.models.Captain;
import com.example.miniapp.models.Customer;
import com.example.miniapp.models.Payment;
import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.PaymentRepository;
import com.example.miniapp.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final TripRepository tripRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, TripRepository tripRepository) {
        this.paymentRepository = paymentRepository;
        this.tripRepository = tripRepository;
    }

    public Payment addPayment(Payment payment) {

        if(payment.getTrip() != null) {
            tripRepository.save(payment.getTrip());
        }

        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {

        Optional<Payment> payment = paymentRepository.findById(id);

        if(payment.isEmpty()) {
            throw new RuntimeException("Payment not found");
        }

        return payment.get();
    }

    public Payment updatePayment(Long id, Payment payment) {

        Optional<Payment> paymentOptional = paymentRepository.findById(id);

        if (paymentOptional.isEmpty()) {

            throw new RuntimeException("Payment not found");
        }

        paymentOptional.get().setAmount(payment.getAmount());
        paymentOptional.get().setPaymentMethod(payment.getPaymentMethod());
        paymentOptional.get().setPaymentStatus(payment.getPaymentStatus());
        return paymentRepository.save(paymentOptional.get());
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public List<Payment> findPaymentsByTripId(Long tripId) {
        return paymentRepository.findByTripId(tripId);
    }

    public List<Payment> findByAmountThreshold(Double threshold) {
        return paymentRepository.findByAmountGreaterThan(threshold);
    }

    public void seedPayments(){
        Customer customer = new Customer("customer","customer@gmail.com","012332");
        Captain captain = new Captain("Captain","1234",2.1);
        Trip trip = new Trip(
                LocalDateTime.of(2025, 5, 10, 14, 30),
                "Dubai",
                "Abu Dhabi",
                120.0
        );
        trip.setCustomer(customer);
        trip.setCaptain(captain);
        tripRepository.save(trip);
        Trip trip2 = new Trip(
                LocalDateTime.of(2026, 5, 10, 14, 30),
                "Dubai",
                "Abu Dhabi",
                120.0
        );
        trip2.setCustomer(customer);
        trip2.setCaptain(captain);
        tripRepository.save(trip2);
        Payment payment = new Payment(10.1,"card",true);
        payment.setTrip(trip);
        paymentRepository.save(payment);
    }

}
