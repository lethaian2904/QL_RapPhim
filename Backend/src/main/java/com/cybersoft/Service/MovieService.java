package com.cybersoft.Service;

import com.cybersoft.Entity.Movie;
import com.cybersoft.Repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getNowPlayingMovies() {
        // Đặt logic truy vấn để lấy danh sách các bộ phim đang chiếu
        // (Có thể sử dụng các phương thức từ movieRepository)
        return movieRepository.findAll();
    }

    public List<String> getAllGenres() {
        return movieRepository.findAllGenres();
    }

    public List<Movie> searchMoviesByTitle(String keyword) {
        return movieRepository.findByTitleContaining(keyword);
    }

}
