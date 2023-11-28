package com.cybersoft.Service;

import com.cybersoft.Entity.Showtime;
import com.cybersoft.Repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    public List<Showtime> getShowtimesByCinema(Long cinemaId) {
        return showtimeRepository.findByCinemaId(cinemaId);
    }
}

