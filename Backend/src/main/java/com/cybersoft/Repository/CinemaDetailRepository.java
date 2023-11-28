package com.cybersoft.Repository;

import com.cybersoft.Entity.Cinema;
import com.cybersoft.Entity.CinemaDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaDetailRepository extends JpaRepository<CinemaDetail, Long> {
    CinemaDetail findByCinema(Cinema cinema);
}

