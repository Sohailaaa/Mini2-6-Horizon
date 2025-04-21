package com.example.miniapp.services;

import com.example.miniapp.models.Captain;
import com.example.miniapp.models.Customer;
import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.CaptainRepository;
import com.example.miniapp.repositories.CustomerRepository;
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
    private final CaptainRepository captainRepository;

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    public TripService(TripRepository tripRepository, CaptainRepository captainRepository, CustomerRepository customerRepository) {
        this.tripRepository = tripRepository;
        this.captainRepository = captainRepository;
        this.customerRepository = customerRepository;
    }

    public Trip addTrip(Trip trip) {
        if(trip.getCustomer() != null) {
            customerRepository.save(trip.getCustomer());
        }

        if(trip.getCaptain() != null) {
            captainRepository.save(trip.getCaptain());
        }
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