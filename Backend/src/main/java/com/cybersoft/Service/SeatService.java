package com.cybersoft.Service;

import com.cybersoft.Entity.Seat;
import com.cybersoft.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat updateSeatAvailability(Long seatId) {
        Optional<Seat> optionalSeat = seatRepository.findById(seatId);

        if (optionalSeat.isPresent()) {
            Seat seat = optionalSeat.get();
            seat.setIsAvailable(true);  // Assuming 1 represents true for availability
            return seatRepository.save(seat);
        } else {
            // Handle the case when the seat with the given ID is not found
            throw new RuntimeException("Seat with ID " + seatId + " not found");
        }
    }
}
