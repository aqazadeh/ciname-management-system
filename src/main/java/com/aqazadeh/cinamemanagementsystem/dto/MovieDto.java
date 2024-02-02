package com.aqazadeh.cinamemanagementsystem.dto;

import com.aqazadeh.cinamemanagementsystem.model.Movie;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:1.02.2024
 * Time:19:38
 */

public record MovieDto(
        Long id,
        String name,
        String genre,
        String about
) {
    public static MovieDto convert(Movie movie){
        return new MovieDto(
                movie.getId(),
                movie.getName(),
                movie.getGenre(),
                movie.getAbout()
        );
    }

    public static List<MovieDto> convertList(List<Movie> movies) {
        return movies.stream().map(MovieDto::convert).toList();
    }
}

