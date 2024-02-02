package com.aqazadeh.cinamemanagementsystem.request;

import com.aqazadeh.cinamemanagementsystem.model.Movie;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:1.02.2024
 * Time:20:05
 */

public record CreateMovieRequest(
        @NotEmpty
        @Size(min = 2)
        String name,
        @NotEmpty
        @Size(min = 2)
        String genre,
        @NotEmpty
        @Size(min = 10)
        String about
) {
    public static Movie convert(CreateMovieRequest request) {
        return Movie.builder()
                .name(request.name())
                .genre(request.genre())
                .about(request.about())
                .build();
    }
}
