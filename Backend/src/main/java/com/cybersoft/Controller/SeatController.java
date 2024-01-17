package com.cybersoft.Controller;

import com.cybersoft.Entity.Seat;
import com.cybersoft.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getTicketTypes() {
        return seatService.getAllSeats();
    }

    @PutMapping("/{seatId}/updateAvailability")  // Define the path for updating availability
    public Seat updateSeatAvailability(@PathVariable Long seatId) {
        return seatService.updateSeatAvailability(seatId);
    }

}
