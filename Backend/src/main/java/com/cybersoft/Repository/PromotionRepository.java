package com.cybersoft.Repository;

import com.cybersoft.Entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    // Define custom queries if needed
}
