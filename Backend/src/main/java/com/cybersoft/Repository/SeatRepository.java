package com.cybersoft.Repository;

import com.cybersoft.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    // Các phương thức truy vấn cụ thể có thể được thêm vào đây
}
