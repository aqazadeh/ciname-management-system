package com.aqazadeh.cinamemanagementsystem.exception;

import com.aqazadeh.cinamemanagementsystem.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 30.01.2024
 * Time: 21:11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    private ResponseEntity<ExceptionDto> handler(UserException exception) {
        ExceptionDto exceptionDto = new ExceptionDto(List.of(exception.getMessage()), LocalDateTime.now());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MovieException.class)
    private ResponseEntity<ExceptionDto> handler(MovieException exception) {
        ExceptionDto exceptionDto = new ExceptionDto(List.of(exception.getMessage()), LocalDateTime.now());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ExceptionDto> handler(MethodArgumentNotValidException exception) {

        List<String> errorList = exception.getAllErrors().stream().map(e -> e.getObjectName() + " " + e.getDefaultMessage()).toList();

        ExceptionDto exceptionDto = new ExceptionDto(errorList, LocalDateTime.now());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

}
