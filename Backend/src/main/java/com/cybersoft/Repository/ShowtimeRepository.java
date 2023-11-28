package com.cybersoft.Repository;

import com.cybersoft.Entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findByCinemaId(Long cinemaId);
}

