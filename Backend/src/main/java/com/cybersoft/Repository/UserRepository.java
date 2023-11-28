package com.cybersoft.Repository;

import com.cybersoft.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByUsernameAndPassword(String username, String password);
}
