package com.aqazadeh.cinamemanagementsystem.dto;

import com.aqazadeh.cinamemanagementsystem.model.User;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 30.01.2024
 * Time: 19:23
 */

public record UserDto(
    Long id,
    String username,
    String name,
    String surname,
    String email
) {
    public static UserDto converter(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getName(), user.getSurname(), user.getEmail());
    }

    public static List<UserDto> convertList(List<User> users){
        return users.stream().map(UserDto::converter).toList();
    }
}

