package com.example.miniapp.services;

import com.example.miniapp.models.Payment;
import com.example.miniapp.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment addPayment(Payment payment) {
        return null;
    }

    public List<Payment> getAllPayments() {
        return null;
    }

    public Payment getPaymentById(Long id) {
        return null;
    }

    public Payment updatePayment(Long id, Payment payment) {
        return null;
    }

    public void deletePayment(Long id) {
    }

    public List<Payment> findPaymentsByTripId(Long tripId) {
        return null;
    }

    public List<Payment> findByAmountThreshold(Double threshold) {
        return null;
    }

}
