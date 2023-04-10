package com.example.rest_api_spring.rest;


import com.example.rest_api_spring.dto.FileDto;
import com.example.rest_api_spring.exception.ResponseMessage;
import com.example.rest_api_spring.service.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/file")
public class FileRestControllerV1 {

    private final StorageService storageService;

    @Autowired
    public FileRestControllerV1(StorageService storageService) {
        this.storageService = storageService;
    }


    @PostMapping("/upload")
    public @ResponseBody ResponseEntity<ResponseMessage> upload(@RequestParam(value = "file") MultipartFile file) {
        try {
            storageService.save(file);

            String message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            String message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileDto>> getListFiles() {
        List<FileDto> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileRestControllerV1.class, "getFile", path.getFileName().toString())
                    .build().toString();

            return new FileDto(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    /* @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    } */


}
