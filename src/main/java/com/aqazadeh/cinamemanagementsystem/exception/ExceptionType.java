package com.aqazadeh.cinamemanagementsystem.exception;

import lombok.Getter;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:30.01.2024
 * Time:19:52
 */
@Getter
public enum ExceptionType {
    USER_ALREADY_EXISTS("Username ve ya Email sistemde movcuddur"),
    USER_NOT_FOUND("USER NOT FOUND"),

    MOVIE_NOT_FOUND("movie not found"),
    TICKET_NOT_FOUND("ticket not found");


    private String message;
    ExceptionType(String s) {
        message = s;
    }
}
