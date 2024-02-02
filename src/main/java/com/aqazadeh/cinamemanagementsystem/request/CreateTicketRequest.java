package com.aqazadeh.cinamemanagementsystem.request;

import com.aqazadeh.cinamemanagementsystem.model.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:1.02.2024
 * Time:21:43
 */

public record CreateTicketRequest(
        @JsonProperty("seat_number")
        String seatNumber,
        @JsonProperty("star_time")
        LocalDateTime startTime
) {
    public static Ticket convert(CreateTicketRequest request){
        return Ticket.builder()
                .seatNumber(request.seatNumber())
                .startTime(request.startTime())
                .build();
    }
}
