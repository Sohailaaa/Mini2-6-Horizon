package com.example.miniapp.services;

import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id) {
        Optional<Trip> tripOptional = tripRepository.findById(id);
        return tripOptional.orElse(null);
    }

    public Trip updateTrip(Long id, Trip trip) {
        return tripRepository.findById(id).map(existingTrip -> {
            existingTrip.setTripDate(trip.getTripDate());
            existingTrip.setOrigin(trip.getOrigin());
            existingTrip.setDestination(trip.getDestination());
            existingTrip.setTripCost(trip.getTripCost());
            existingTrip.setCaptain(trip.getCaptain());
            existingTrip.setCustomer(trip.getCustomer());
            return tripRepository.save(existingTrip);
        }).orElse(null);
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findByTripDateBetween(startDate, endDate);
    }

    public List<Trip> findTripsByCaptainId(Long captainId) {
        return tripRepository.findByCaptainId(captainId);
    }
}