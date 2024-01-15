package com.cybersoft.Service;

import com.cybersoft.Entity.Seat;
import com.cybersoft.Repository.ShowtimeSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeSeatService {

    @Autowired
    private ShowtimeSeatRepository showtimeSeatRepository;

    // Method to get available seats for a specific showtime
    public List<Seat> getAvailableSeats(Long showtimeId) {
        // Implement the logic to retrieve available seats for the given showtimeId
        // You may need to query the database or perform any other necessary operations

        // For illustration purposes, let's assume you have a method in ShowtimeSeatRepository
        // to retrieve available seats based on showtimeId
        return showtimeSeatRepository.findAvailableSeatsByShowtimeId(showtimeId);
    }
}
