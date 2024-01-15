package com.cybersoft.Repository;

import com.cybersoft.Entity.MovieDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDetailRepository extends JpaRepository<MovieDetail, Long> {
    // Các phương thức truy vấn cụ thể có thể được thêm vào đây
}

