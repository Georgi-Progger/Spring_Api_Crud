package com.example.rest_api_spring.service.storage;

import com.example.rest_api_spring.model.FileEntity;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    FileEntity save(MultipartFile file);

    Resource load(String filename);

    void delete();

    Stream<Path> loadAll();
}
