package com.calendar.demo.service;

import com.calendar.demo.entity.User;
import com.calendar.demo.entity.dto.UserDTO;

import java.util.Optional;

public interface UserService {
    public void saveUserByDto(UserDTO userDTO);
}
