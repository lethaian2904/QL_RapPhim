package com.cybersoft.Controller;

import com.cybersoft.Entity.Seat;
import com.cybersoft.Service.ShowtimeSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeSeatController {

    @Autowired
    private ShowtimeSeatService showtimeSeatService;

    @GetMapping("/{showtime_id}/available_seats")
    public ResponseEntity<List<Seat>> getAvailableSeats(@PathVariable Long showtime_id) {
        List<Seat> availableSeats = showtimeSeatService.getAvailableSeats(showtime_id);
        if (!availableSeats.isEmpty()) {
            return new ResponseEntity<>(availableSeats, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

