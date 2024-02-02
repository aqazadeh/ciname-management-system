package com.aqazadeh.cinamemanagementsystem.controller;

import com.aqazadeh.cinamemanagementsystem.dto.TicketDto;
import com.aqazadeh.cinamemanagementsystem.request.CreateTicketRequest;
import com.aqazadeh.cinamemanagementsystem.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 1.02.2024
 * Time: 21:11
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ticket")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/{userId}/movie/{movieId}")
    public ResponseEntity<TicketDto> createTicket(
            @PathVariable Long userId,
            @PathVariable Long movieId,
            @RequestBody CreateTicketRequest request
    ) {
        TicketDto ticket = ticketService.createTicket(userId, movieId, request);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable Long id) {
        TicketDto ticketDto = ticketService.getById(id);
        return ResponseEntity.ok(ticketDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
