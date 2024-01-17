package com.cybersoft.Controller;

import com.cybersoft.Entity.Movie;
import com.cybersoft.Repository.MovieRepository;
import com.cybersoft.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5501")
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

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> optionalMovie = movieService.getMovieById(id);

        return optionalMovie.map(movie -> ResponseEntity.ok(movie))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

