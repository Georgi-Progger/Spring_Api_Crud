package com.example.rest_api_spring.rest;


import com.example.rest_api_spring.dto.FileDto;
import com.example.rest_api_spring.exception.ResponseMessage;
import com.example.rest_api_spring.service.FileService;
import com.example.rest_api_spring.service.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/files")
public class FileRestControllerV1 {

    private final StorageService storageService;
    private final FileService fileService;

    @Autowired
    public FileRestControllerV1(StorageService storageService, FileService fileService) {
        this.storageService = storageService;
        this.fileService = fileService;
    }


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> upload(@RequestParam(value = "file") MultipartFile file) {
        try {
            fileService.create(storageService.save(file));
            String message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            String message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping()
    public List<FileDto> getListFiles() {
        return FileDto.getFilesDto(fileService.loadAll());
    }

    @GetMapping("/{id}")
    public FileDto getOneFile(@PathVariable int Id) {
        return FileDto.getFileDto(fileService.getById(Id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFile(@PathVariable int Id){
        fileService.delete(Id);
    }
}
