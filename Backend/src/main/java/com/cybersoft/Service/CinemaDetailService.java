package com.cybersoft.Service;

import com.cybersoft.Entity.Cinema;
import com.cybersoft.Entity.CinemaDetail;
import com.cybersoft.Repository.CinemaDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaDetailService {

    @Autowired
    private CinemaDetailRepository cinemaDetailRepository;

    public CinemaDetail getCinemaDetailByCinema(Cinema cinema) {
        return cinemaDetailRepository.findByCinema(cinema);
    }
}

