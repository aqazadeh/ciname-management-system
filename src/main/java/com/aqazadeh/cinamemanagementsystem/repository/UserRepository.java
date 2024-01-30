package com.aqazadeh.cinamemanagementsystem.repository;

import com.aqazadeh.cinamemanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:30.01.2024
 * Time:19:45
 */

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrEmail(String username, String email);
}
