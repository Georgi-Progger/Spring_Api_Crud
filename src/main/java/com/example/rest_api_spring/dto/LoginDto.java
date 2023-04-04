package com.example.rest_api_spring.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginDto {
    @NotEmpty(message = "username field cannot be empty")
    private String name;
    @NotEmpty(message = "password field cannot be empty")
    private String password;
}
