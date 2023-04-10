package com.example.rest_api_spring.service.impl;

import com.example.rest_api_spring.model.FileEntity;
import com.example.rest_api_spring.repository.FileRepository;
import com.example.rest_api_spring.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public List<FileEntity> loadAll() {
        return fileRepository.findAll();
    }

    @Override
    public FileEntity create(FileEntity fileEntity) {
        return null;
    }

    @Override
    public FileEntity getById(Integer integer) {
        return null;
    }

    @Override
    public FileEntity update(FileEntity fileEntity) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
