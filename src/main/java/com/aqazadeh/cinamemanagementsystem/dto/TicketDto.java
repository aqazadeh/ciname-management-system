package com.aqazadeh.cinamemanagementsystem.dto;

import com.aqazadeh.cinamemanagementsystem.model.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:1.02.2024
 * Time:21:20
 */

public record TicketDto(
        Long id,
        @JsonProperty("serial_number")
        String serialNumber,
        @JsonProperty("seat_number")
        String seatNumber,
        @JsonProperty("star_time")
        LocalDateTime startTime,
        MovieDto movie
) {

    public static TicketDto convert(Ticket ticket){
        return  new TicketDto(
                ticket.getId(),
                ticket.getSerialNumber(),
                ticket.getSeatNumber(),
                ticket.getStartTime(),
                MovieDto.convert(ticket.getMovie())
        );
    }

    public static List<TicketDto> convertList(List<Ticket> tickets){
        return tickets.stream().map(TicketDto::convert).toList();
    }
}
