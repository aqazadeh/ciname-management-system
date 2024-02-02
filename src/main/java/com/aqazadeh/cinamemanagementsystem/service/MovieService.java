package com.aqazadeh.cinamemanagementsystem.service;

import com.aqazadeh.cinamemanagementsystem.dto.MovieDto;
import com.aqazadeh.cinamemanagementsystem.dto.TicketDto;
import com.aqazadeh.cinamemanagementsystem.request.CreateMovieRequest;
import com.aqazadeh.cinamemanagementsystem.request.UpdateMovieRequest;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 1.02.2024
 * Time: 19:38
 */

public interface MovieService {
    List<MovieDto> getAll();

    MovieDto findById(Long id);
    MovieDto update(Long id, UpdateMovieRequest request);

    MovieDto addMovie(CreateMovieRequest request);
    void delete(Long id);
}
