package com.aqazadeh.cinamemanagementsystem.repository;

import com.aqazadeh.cinamemanagementsystem.model.Movie;
import com.aqazadeh.cinamemanagementsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:1.02.2024
 * Time:21:35
 */

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> getTicketByMovie(Movie movie);
}
