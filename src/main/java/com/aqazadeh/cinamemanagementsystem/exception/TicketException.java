package com.aqazadeh.cinamemanagementsystem.exception;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 1.02.2024
 * Time: 21:40
 */

public class TicketException extends RuntimeException{
    public TicketException(ExceptionType message) {
        super(message.getMessage());
    }
}
