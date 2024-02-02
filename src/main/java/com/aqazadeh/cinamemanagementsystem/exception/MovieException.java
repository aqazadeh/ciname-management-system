package com.aqazadeh.cinamemanagementsystem.exception;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 1.02.2024
 * Time: 19:53
 */

public class MovieException extends RuntimeException{
    public MovieException(ExceptionType message) {
        super(message.getMessage());
    }
}
