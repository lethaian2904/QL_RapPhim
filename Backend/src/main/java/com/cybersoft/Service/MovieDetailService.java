package com.cybersoft.Service;

import com.cybersoft.Entity.MovieDetail;
import com.cybersoft.Repository.MovieDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieDetailService {
    private final MovieDetailRepository movieDetailRepository;

    @Autowired
    public MovieDetailService(MovieDetailRepository movieDetailRepository) {
        this.movieDetailRepository = movieDetailRepository;
    }

    public Optional<MovieDetail> getMovieDetailById(Long movieDetailId) {
        return movieDetailRepository.findById(movieDetailId);
    }

    // Các phương thức khác cho nghiệp vụ cụ thể có thể được thêm vào đây
}

