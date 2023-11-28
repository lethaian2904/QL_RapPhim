package com.cybersoft.Entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "showtime_seats")

public class ShowtimeSeat {

    @Id
    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private Showtime showtime;

    @Id
    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    // Các trường khác của ShowtimeSeat (nếu có)
}
