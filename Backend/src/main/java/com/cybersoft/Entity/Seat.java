package com.cybersoft.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cinema_id", nullable = false)
    private Long cinemaId;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

    @Column(name = "row_numberr", nullable = false)
    private Integer rowNumber;

    // Constructors, getters, setters, and other methods as needed

    // Default constructor
    public Seat() {
    }

    // Parameterized constructor
    public Seat(Long cinemaId, Integer seatNumber, Boolean isAvailable, Integer rowNumber) {
        this.cinemaId = cinemaId;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
        this.rowNumber = rowNumber;
    }
}

