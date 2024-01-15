package com.cybersoft.Repository;

import com.cybersoft.Entity.Seat;
import com.cybersoft.Entity.ShowtimeSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeSeatRepository extends JpaRepository<ShowtimeSeat, Long> {

    // Truy vấn tùy chỉnh để lấy danh sách ghế trống cho một lịch chiếu cụ thể
    @Query("SELECT s.seat FROM ShowtimeSeat s WHERE s.showtime.id = :showtimeId AND s.seat.isAvailable = true")
    List<Seat> findAvailableSeatsByShowtimeId(@Param("showtimeId") Long showtimeId);
}
