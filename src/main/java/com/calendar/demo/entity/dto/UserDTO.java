package com.calendar.demo.entity.dto;

import lombok.Builder;

@Builder
public record UserDTO(
    Long id,
    String username,
    String password,
    String color
) {

}
