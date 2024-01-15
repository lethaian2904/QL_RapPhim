package com.cybersoft.Controller;

import com.cybersoft.Entity.Movie;
import com.cybersoft.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/now_playing")
    public List<Movie> getNowPlayingMovies() {
        return movieService.getNowPlayingMovies();
    }

    @GetMapping("/genres")
    public List<String> getAllGenres() {
        return movieService.getAllGenres();
    }

    @GetMapping("/search/{title}")
    public List<Movie> searchMoviesByTitle(@RequestParam String title) {
        return movieService.searchMoviesByTitle(title);
    }
}

