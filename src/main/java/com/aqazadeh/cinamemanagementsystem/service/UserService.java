package com.aqazadeh.cinamemanagementsystem.service;

import com.aqazadeh.cinamemanagementsystem.dto.UserDto;
import com.aqazadeh.cinamemanagementsystem.request.CreateUserRequest;
import com.aqazadeh.cinamemanagementsystem.request.UpdateUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 30.01.2024
 * Time: 19:34
 */


public interface UserService {
    UserDto createUser(CreateUserRequest userRequest);
    UserDto getById(Long id);

    List<UserDto> getAll();

    UserDto updateUser(long id, UpdateUserRequest request);
}
