package com.aqazadeh.cinamemanagementsystem.exception;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 30.01.2024
 * Time: 19:50
 */

public class UserException extends RuntimeException{

    public UserException(ExceptionType message) {
        super(message.getMessage());
    }
}
