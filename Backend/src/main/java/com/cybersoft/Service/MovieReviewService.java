package com.cybersoft.Service;

import com.cybersoft.Entity.Movie;
import com.cybersoft.Entity.MovieReview;
import com.cybersoft.Entity.User;
import com.cybersoft.Repository.MovieRepository;
import com.cybersoft.Repository.MovieReviewRepository;
import com.cybersoft.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieReviewService {

    private final MovieReviewRepository movieReviewRepository;
    private final MovieRepository MovieRepository;
    private final UserRepository UserRepository;

    @Autowired
    public MovieReviewService(MovieReviewRepository movieReviewRepository, com.cybersoft.Repository.MovieRepository movieRepository, com.cybersoft.Repository.UserRepository userRepository) {
        this.movieReviewRepository = movieReviewRepository;
        MovieRepository = movieRepository;
        UserRepository = userRepository;
    }

    public List<MovieReview> getReviewsByMovieId(Long movieId) {
        return movieReviewRepository.findByMovieId(movieId);
    }

    public ResponseEntity<String> addReview(Long movieId, Long userId, Integer rating, String reviewText) {
        Optional<Movie> movieOptional = MovieRepository.findById(movieId);
        Optional<User> userOptional = UserRepository.findById(userId);

        if (movieOptional.isPresent() && userOptional.isPresent()) {
            Movie movie = movieOptional.get();
            User user = userOptional.get();

            MovieReview newReview = new MovieReview();
            newReview.setMovie(movie);
            newReview.setUser(user);
            newReview.setRating(rating);
            newReview.setReview(reviewText);

            movieReviewRepository.save(newReview);

            return new ResponseEntity<>("Đánh giá và nhận xét đã được thêm thành công.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Phim hoặc người dùng không tồn tại.", HttpStatus.NOT_FOUND);
        }
    }
}

