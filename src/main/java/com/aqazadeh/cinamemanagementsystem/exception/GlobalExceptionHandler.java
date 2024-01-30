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

    @ExceptionHandler(ApplicationException.class)
    private ResponseEntity<ExceptionDto> handler(ApplicationException exception) {
        ExceptionDto exceptionDto = new ExceptionDto(exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<List<ExceptionDto>> handler(MethodArgumentNotValidException exception) {
        List<ExceptionDto> exceptionDtoList = new ArrayList<>();
        exception.getAllErrors().stream().forEach(e -> {
           exceptionDtoList. add(new ExceptionDto(e.getObjectName() + " " +e.getDefaultMessage(), LocalDateTime.now()));
        });
        return new ResponseEntity<>(exceptionDtoList, HttpStatus.BAD_REQUEST);
    }

}
