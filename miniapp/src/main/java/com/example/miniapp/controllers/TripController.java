package com.example.miniapp.controllers;

import com.example.miniapp.models.Captain;
import com.example.miniapp.models.Customer;
import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.CaptainRepository;
import com.example.miniapp.repositories.CustomerRepository;
import com.example.miniapp.repositories.PaymentRepository;
import com.example.miniapp.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }
    @Autowired
    private CaptainRepository captainRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/addTrip")
    public Trip addTrip(@RequestBody Trip trip) {
        if (trip.getCaptain().getId() != null) {
            Captain captain = captainRepository.findById(trip.getCaptain().getId())
                    .orElseThrow(() -> new RuntimeException("Captain not found"));
            trip.setCaptain(captain);
        }

        if (trip.getCustomer().getId() != null) {
            Customer customer = customerRepository.findById(trip.getCustomer().getId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            trip.setCustomer(customer);
        }
        return tripService.addTrip(trip);
    }

    @GetMapping("/allTrips")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    @PutMapping("/update/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        return tripService.updateTrip(id, trip);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return "Trip deleted successfully";
    }

    @GetMapping("/findByDateRange")
    public List<Trip> findTripsWithinDateRange(@RequestParam LocalDate startDate, @RequestParam
    LocalDate endDate) {
        return tripService.findTripsWithinDateRange(startDate.atStartOfDay(), endDate.atStartOfDay());
    }

    @GetMapping("/findByCaptainId")
    public List<Trip> findTripsByCaptainId(@RequestParam Long captainId) {
        return tripService.findTripsByCaptainId(captainId);
    }

}