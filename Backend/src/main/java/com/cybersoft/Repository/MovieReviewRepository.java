package com.cybersoft.Repository;

import com.cybersoft.Entity.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {
    List<MovieReview> findByMovieId(Long movieId);
    // Các phương thức truy vấn cụ thể có thể được thêm vào đây
}
