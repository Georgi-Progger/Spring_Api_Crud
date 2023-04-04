package com.example.rest_api_spring.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterDto {
    @NotEmpty(message = "username field cannot be empty")
    private String name;
    @NotEmpty(message = "email field cannot be empty")
    private String email;
    @NotEmpty(message = "password field cannot be empty")
    private String password;
}
