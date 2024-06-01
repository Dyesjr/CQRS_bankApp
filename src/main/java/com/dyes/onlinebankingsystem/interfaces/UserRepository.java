package com.dyes.onlinebankingsystem.interfaces;

import com.dyes.onlinebankingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findById (Long userId);
}
