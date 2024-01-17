package com.cybersoft.Controller;

import com.cybersoft.Entity.MovieReview;
import com.cybersoft.Service.MovieReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api/movies")
public class MovieReviewController {

    private final MovieReviewService movieReviewService;

    @Autowired
    public MovieReviewController(MovieReviewService movieReviewService) {
        this.movieReviewService = movieReviewService;
    }

    @GetMapping("/{movie_id}/reviews")
    public List<MovieReview> getMovieReviews(@PathVariable("movie_id") Long movieId) {
        return movieReviewService.getReviewsByMovieId(movieId);
    }

    @PostMapping("/{movie_id}/reviews")
    public ResponseEntity<String> addReview(
            @PathVariable("movie_id") Long movieId,
            @RequestParam("user_id") Long userId,
            @RequestParam("rating") Integer rating,
            @RequestParam("review") String reviewText) {

        return movieReviewService.addReview(movieId, userId, rating, reviewText);
    }
}
