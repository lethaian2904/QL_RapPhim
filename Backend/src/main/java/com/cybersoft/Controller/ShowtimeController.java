package com.cybersoft.Controller;

import com.cybersoft.Entity.Showtime;
import com.cybersoft.Service.ShowtimeService;
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
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping("/{cinema_id}/showtimes")
    public ResponseEntity<List<Showtime>> getShowtimesByCinema(@PathVariable Long cinema_id) {
        List<Showtime> showtimes = showtimeService.getShowtimesByCinema(cinema_id);
        if (!showtimes.isEmpty()) {
            return new ResponseEntity<>(showtimes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

