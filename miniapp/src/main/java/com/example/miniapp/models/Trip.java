package com.example.miniapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime tripDate;
    private String origin;
    private String destination;
    private Double tripCost;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "captain_id")
    @JsonBackReference
    private Captain captain;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    @OneToOne(mappedBy = "trip")
    private Payment payment;

    public Trip(LocalDateTime tripDate, String origin, String destination, Double tripCost) {
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
    }
}