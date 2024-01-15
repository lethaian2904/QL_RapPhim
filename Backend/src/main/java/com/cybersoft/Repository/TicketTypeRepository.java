package com.cybersoft.Repository;

import com.cybersoft.Entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
    // Các phương thức truy vấn đặc biệt nếu cần
}
