package com.example.rest_api_spring.repository;

import com.example.rest_api_spring.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
