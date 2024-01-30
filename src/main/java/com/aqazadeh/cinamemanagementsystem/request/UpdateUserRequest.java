package com.aqazadeh.cinamemanagementsystem.request;

import com.aqazadeh.cinamemanagementsystem.model.User;
import jakarta.validation.constraints.NotEmpty;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:30.01.2024
 * Time:20:45
 */

public record UpdateUserRequest(
        @NotEmpty
        String name,
        @NotEmpty
        String surname,
        @NotEmpty
        String email,
        @NotEmpty
        String username
) {
    public static User convert(UpdateUserRequest request, User user) {
        user.setName(request.name());
        user.setSurname(request.surname());
        user.setEmail(request.email());
        user.setUsername(request.username());
        return user;
    }

}
