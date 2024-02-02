package com.aqazadeh.cinamemanagementsystem.service.impl;

import com.aqazadeh.cinamemanagementsystem.dto.MovieDto;
import com.aqazadeh.cinamemanagementsystem.dto.TicketDto;
import com.aqazadeh.cinamemanagementsystem.exception.ExceptionType;
import com.aqazadeh.cinamemanagementsystem.exception.MovieException;
import com.aqazadeh.cinamemanagementsystem.model.Movie;
import com.aqazadeh.cinamemanagementsystem.repository.MovieRepository;
import com.aqazadeh.cinamemanagementsystem.request.CreateMovieRequest;
import com.aqazadeh.cinamemanagementsystem.request.UpdateMovieRequest;
import com.aqazadeh.cinamemanagementsystem.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 1.02.2024
 * Time: 19:39
 */
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final TicketServiceImpl ticketService;

    @Override
    public List<MovieDto> getAll() {
        List<Movie> all = movieRepository.findAll();
        List<MovieDto> movieDtos = MovieDto.convertList(all);
        return movieDtos;
    }

    @Override
    public MovieDto findById(Long id) {
        Movie movie = getMovieById(id);
        MovieDto convert = MovieDto.convert(movie);
        return convert;
    }

    @Override
    public MovieDto update(Long id, UpdateMovieRequest request) {
        Movie movie = getMovieById(id);
        Movie convert = UpdateMovieRequest.convert(movie, request);
        Movie save = movieRepository.save(convert);
        return MovieDto.convert(save);

    }



    @Override
    public MovieDto addMovie(CreateMovieRequest request) {
        Movie convert = CreateMovieRequest.convert(request);
        Movie save = movieRepository.save(convert);
        return MovieDto.convert(save);

    }

    @Override
    public void delete(Long id) {
        Movie movie = getMovieById(id);
        movieRepository.delete(movie);
    }


    protected Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieException(ExceptionType.MOVIE_NOT_FOUND));
    }
}
