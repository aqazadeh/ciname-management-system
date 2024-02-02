package com.aqazadeh.cinamemanagementsystem.request;

import com.aqazadeh.cinamemanagementsystem.model.Movie;
import com.aqazadeh.cinamemanagementsystem.repository.MovieRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:1.02.2024
 * Time:20:16
 */
@Slf4j
public record UpdateMovieRequest(
        String name,
        String genre,
        String about
) {
    public static Movie convert(Movie movie , UpdateMovieRequest request) {
        log.info(request.about() + " " + request.genre() );
        if (request.name() != null) movie.setName(request.name());
        if (request.genre() != null) movie.setGenre(request.genre());
        if (request.about() != null) movie.setAbout(request.about());

        return movie;
    }
}
