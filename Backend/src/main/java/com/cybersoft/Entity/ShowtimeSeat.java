package com.cybersoft.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "showtime_seats")
public class ShowtimeSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private Showtime showtime;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    // Các trường khác của ShowtimeSeat (nếu có)

    public ShowtimeSeat() {
        // Hàm tạo mặc định
    }

    public ShowtimeSeat(Showtime showtime, Seat seat) {
        this.showtime = showtime;
        this.seat = seat;
    }
}
