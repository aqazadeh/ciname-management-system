package com.aqazadeh.cinamemanagementsystem.service;

import com.aqazadeh.cinamemanagementsystem.dto.TicketDto;
import com.aqazadeh.cinamemanagementsystem.model.Movie;
import com.aqazadeh.cinamemanagementsystem.model.Ticket;
import com.aqazadeh.cinamemanagementsystem.request.CreateTicketRequest;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:1.02.2024
 * Time:21:15
 */

public interface TicketService {
    TicketDto createTicket(Long userId, Long movieId, CreateTicketRequest request);
    TicketDto getById(Long id);
    void deleteTicket(Long id);
    List<TicketDto> getMovieTickets(Long id);

}
