package com.calendar.demo.service.impl;

import com.calendar.demo.entity.User;
import com.calendar.demo.entity.dto.UserDTO;
import com.calendar.demo.repository.UserRepository;
import com.calendar.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void saveUserByDto(UserDTO userDTO) {
        if(userRepository.findByUsername(userDTO.username()).isEmpty()){
            User user = new User(userDTO.id(), userDTO.username(), passwordEncoder.encode(userDTO.password()), userDTO.color());
            userRepository.save(user);
        }
    }
}
