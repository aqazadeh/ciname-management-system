package com.aqazadeh.cinamemanagementsystem.exception;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 30.01.2024
 * Time: 19:50
 */

public class ApplicationException extends RuntimeException{

    public ApplicationException(ExceptionType message) {
        super(message.getMessage());
    }
}
