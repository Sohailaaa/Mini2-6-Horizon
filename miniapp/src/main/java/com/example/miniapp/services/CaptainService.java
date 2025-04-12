package com.example.miniapp.services;

import com.example.miniapp.models.Captain;
import com.example.miniapp.repositories.CaptainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaptainService {
    // Dependency Injection
    private final CaptainRepository captainRepository;

    public CaptainService(CaptainRepository captainRepository) {
        this.captainRepository = captainRepository;
    }


    public Captain addCaptain(Captain captain) {
        return null;
    }

    public List<Captain> getAllCaptains() {
        return null;
    }

    public Captain getCaptainById(Long id) {
        return null;
    }

    public List<Captain> getCaptainsByRating(Double ratingThreshold) {
        return null;
    }

    public Captain getCaptainByLicenseNumber(String licenseNumber) {
        return null;
    }


}
