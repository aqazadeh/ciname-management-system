package com.aqazadeh.cinamemanagementsystem.service.impl;

import com.aqazadeh.cinamemanagementsystem.dto.UserDto;
import com.aqazadeh.cinamemanagementsystem.exception.ApplicationException;
import com.aqazadeh.cinamemanagementsystem.exception.ExceptionType;
import com.aqazadeh.cinamemanagementsystem.model.User;
import com.aqazadeh.cinamemanagementsystem.repository.UserRepository;
import com.aqazadeh.cinamemanagementsystem.request.CreateUserRequest;
import com.aqazadeh.cinamemanagementsystem.request.UpdateUserRequest;
import com.aqazadeh.cinamemanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 30.01.2024
 * Time: 19:35
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDto createUser(CreateUserRequest userRequest) {
        boolean present = userRepository.findByUsernameOrEmail(userRequest.username(), userRequest.email()).isPresent();
        if(present) throw new ApplicationException(ExceptionType.USER_ALREADY_EXISTS);

        User user = CreateUserRequest.convert(userRequest);

        User save = userRepository.save(user);
        return UserDto.converter(save);
    }

    @Override
    public UserDto getById(Long id) {
        User user = getUserById(id);

        return UserDto.converter(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return UserDto.convertList(users);
    }

    @Override
    public UserDto updateUser(long id, UpdateUserRequest request) {
        User user = getUserById(id);
        User convertedUser = UpdateUserRequest.convert(request, user);
        User updatedUser = userRepository.save(convertedUser);
        return UserDto.converter(updatedUser);
    }

    private User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(ExceptionType.USER_NOT_FOUND));
    }
}
