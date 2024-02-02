package com.aqazadeh.cinamemanagementsystem.controller;

import com.aqazadeh.cinamemanagementsystem.dto.MovieDto;
import com.aqazadeh.cinamemanagementsystem.dto.TicketDto;
import com.aqazadeh.cinamemanagementsystem.request.CreateMovieRequest;
import com.aqazadeh.cinamemanagementsystem.request.UpdateMovieRequest;
import com.aqazadeh.cinamemanagementsystem.service.MovieService;
import com.aqazadeh.cinamemanagementsystem.service.TicketService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 1.02.2024
 * Time: 19:36
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movie")
public class MovieController {
    private final MovieService movieService;
    private final TicketService ticketService;
    @GetMapping()
    private ResponseEntity<List<MovieDto>> getAllMovies(){

        List<MovieDto> movies = movieService.getAll();

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    private ResponseEntity<MovieDto> getById(@PathVariable Long id){
        MovieDto movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    private ResponseEntity<MovieDto> createMovie(@Validated @RequestBody CreateMovieRequest request){
        MovieDto movieDto = movieService.addMovie(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDto);
    }
    @PatchMapping("/{id}")
    private ResponseEntity<MovieDto> updateMovie(
            @PathVariable Long id,
            @RequestBody UpdateMovieRequest request
    ){
        MovieDto update = movieService.update(id, request);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/tickets")
    public ResponseEntity<List<TicketDto>> getMovieTickets(@PathVariable Long id){
        List<TicketDto> tickets = ticketService.getMovieTickets(id);
        return ResponseEntity.ok(tickets);
    }
}
