package com.example.miniapp.services;

import com.example.miniapp.models.Payment;
import com.example.miniapp.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment addPayment(Payment payment) {

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

}
