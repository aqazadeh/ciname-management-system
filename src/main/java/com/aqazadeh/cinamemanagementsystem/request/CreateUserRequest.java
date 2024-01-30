package com.aqazadeh.cinamemanagementsystem.request;

import com.aqazadeh.cinamemanagementsystem.model.User;
import jakarta.validation.constraints.*;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:30.01.2024
 * Time:19:36
 */

public record CreateUserRequest(
        @NotEmpty(message = "Name Bos Ola Bilmez!")
        @Size
        String name,
        @NotEmpty
        @Size
        String surname,
        @NotNull
        @Size
        String username,
        @NotEmpty
        @Size
        @Email
        String email,
        @NotEmpty
        @Size(min = 8, message = "Password Minimum 8 sinvol uzunlugunda olmalidir")
        String password
) {
        public static User convert(CreateUserRequest request) {
                return new User().builder()
                        .name(request.name())
                        .surname(request.surname())
                        .username(request.username())
                        .email(request.email())
                        .password(request.password())
                        .build();
        }
}
