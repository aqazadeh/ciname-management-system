package com.aqazadeh.cinamemanagementsystem.repository;

import com.aqazadeh.cinamemanagementsystem.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:1.02.2024
 * Time:19:50
 */

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
