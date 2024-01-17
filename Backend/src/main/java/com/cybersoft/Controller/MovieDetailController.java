package com.cybersoft.Controller;

import com.cybersoft.Entity.MovieDetail;
import com.cybersoft.Service.MovieDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api/movie-details")
public class MovieDetailController {
    private final MovieDetailService movieDetailService;

    @Autowired
    public MovieDetailController(MovieDetailService movieDetailService) {
        this.movieDetailService = movieDetailService;
    }

    @GetMapping("/{id}")
    public Optional<MovieDetail> getMovieDetailById(@PathVariable("id") Long movieDetailId) {
        return movieDetailService.getMovieDetailById(movieDetailId);
    }

    // Các phương thức khác cho API có thể được thêm vào đây
}

