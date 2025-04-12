package com.example.miniapp.services;

import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip addTrip(Trip trip) {
        return null;
    }

    public List<Trip> getAllTrips() {
        return null;
    }

    public Trip getTripById(Long id) {
        return null;
    }

    public Trip updateTrip(Long id, Trip trip) {
        return null;
    }

    public void deleteTrip(Long id) {
    }

    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return null;
    }

    public List<Trip> findTripsByCaptainId(Long captainId) {
        return null;
    }

}