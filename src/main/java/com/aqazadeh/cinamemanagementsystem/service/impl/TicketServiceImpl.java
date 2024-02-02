package com.aqazadeh.cinamemanagementsystem.service.impl;

import com.aqazadeh.cinamemanagementsystem.dto.TicketDto;
import com.aqazadeh.cinamemanagementsystem.exception.ExceptionType;
import com.aqazadeh.cinamemanagementsystem.exception.TicketException;
import com.aqazadeh.cinamemanagementsystem.model.Movie;
import com.aqazadeh.cinamemanagementsystem.model.Ticket;
import com.aqazadeh.cinamemanagementsystem.model.User;
import com.aqazadeh.cinamemanagementsystem.repository.TicketRepository;
import com.aqazadeh.cinamemanagementsystem.request.CreateTicketRequest;
import com.aqazadeh.cinamemanagementsystem.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 1.02.2024
 * Time: 21:34
 */
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final UserServiceImpl userService;
    private final TicketRepository ticketRepository;
    private final MovieServiceImpl movieService;

    @Override
    public TicketDto createTicket(Long userId, Long movieId, CreateTicketRequest request) {
        User user = userService.getUserById(userId);
        Movie movie = movieService.getMovieById(movieId);
        Ticket ticket = CreateTicketRequest.convert(request);
        ticket.setUser(user);
        ticket.setMovie(movie);

        Ticket save = ticketRepository.save(ticket);
        return TicketDto.convert(save);
    }

    @Override
    public TicketDto getById(Long id) {
        Ticket ticketById = getTicketById(id);
        return TicketDto.convert(ticketById);
    }

    @Override
    public void deleteTicket(Long id) {
        Ticket ticket = getTicketById(id);
        ticketRepository.delete(ticket);
    }


    @Override
    public List<TicketDto> getMovieTickets(Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        List<Ticket> tickets = ticketRepository.getTicketByMovie(movie);
        List<TicketDto> ticketDtos = TicketDto.convertList(tickets);
        return ticketDtos;
    }
    protected Ticket getTicketById(Long id){
        return ticketRepository
                .findById(id)
                .orElseThrow(() -> new TicketException(ExceptionType.TICKET_NOT_FOUND));
    }
}
