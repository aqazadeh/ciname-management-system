package com.aqazadeh.cinamemanagementsystem.controller;

import com.aqazadeh.cinamemanagementsystem.dto.TicketDto;
import com.aqazadeh.cinamemanagementsystem.dto.UserDto;
import com.aqazadeh.cinamemanagementsystem.request.CreateUserRequest;
import com.aqazadeh.cinamemanagementsystem.request.UpdateUserRequest;
import com.aqazadeh.cinamemanagementsystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 30.01.2024
 * Time: 19:21
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    private ResponseEntity<UserDto> createUser(@Validated @RequestBody CreateUserRequest request) {
        UserDto user = userService.createUser(request);
        log.info("UserController - createUser: " + user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> user = userService.getAll();
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long id, @Validated @RequestBody UpdateUserRequest request) {
        UserDto dto = userService.updateUser(id, request);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body("user silindi");
    }

    @GetMapping("/{id}/tickets")
    public ResponseEntity<List<TicketDto>> getUserTickets(@PathVariable Long id) {
        List<TicketDto> userTickets = userService.getUserTickets(id);
        return ResponseEntity.ok(userTickets);
    }
}



