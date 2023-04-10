package com.example.rest_api_spring;

import com.example.rest_api_spring.service.storage.StorageService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RestApiSpringApplication implements CommandLineRunner {
    @Resource
    StorageService storageService;


    public static void main(String[] args) {
        SpringApplication.run(RestApiSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        storageService.init();
    }
}
