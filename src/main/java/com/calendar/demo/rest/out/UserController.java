package com.calendar.demo.rest.out;

import com.calendar.demo.entity.dto.UserDTO;
import com.calendar.demo.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("api/user/register")
    public ResponseEntity<Integer> registerUser(@RequestBody UserDTO userDTO){
        userService.saveUserByDto(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
