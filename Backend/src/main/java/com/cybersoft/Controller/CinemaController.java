package com.cybersoft.Controller;

import com.cybersoft.Entity.Cinema;
import com.cybersoft.Entity.CinemaDetail;
import com.cybersoft.Service.CinemaDetailService;
import com.cybersoft.Service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private CinemaDetailService cinemaDetailService;

    @GetMapping
    public ResponseEntity<List<Cinema>> getAllCinemas() {
        List<Cinema> cinemas = cinemaService.getAllCinemas();
        if (!cinemas.isEmpty()) {
            return new ResponseEntity<>(cinemas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @GetMapping("/{cinema_id}")
    public ResponseEntity<CinemaDetail> getCinemaDetail(@PathVariable Long cinema_id) {
        Cinema cinema = cinemaService.getCinemaById(cinema_id);
        if (cinema != null) {
            CinemaDetail cinemaDetail = cinemaDetailService.getCinemaDetailByCinema(cinema);
            if (cinemaDetail != null) {
                return new ResponseEntity<>(cinemaDetail, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

