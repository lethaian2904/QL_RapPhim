package com.cybersoft.Repository;

import com.cybersoft.Entity.Movie;
import com.cybersoft.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT DISTINCT m.genre FROM Movie m")
    List<String> findAllGenres();

    List<Movie> findByTitleContaining(String keyword);

    Optional<Movie> findById(Long userId);
}

