package com.example.rest_api_spring.dto;

import com.example.rest_api_spring.model.FileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {
    private String fileName;
    private String filePath;


    public static FileDto getFileDto(FileEntity fileEntities){
        FileDto fileInfos = new FileDto(fileEntities.getFileName(), fileEntities.getFilePath());
        return fileInfos;
    }
    public static List<FileDto> getFilesDto(List<FileEntity> fileEntities){
        List<FileDto> fileInfos = fileEntities.stream().map(path -> {
            String filename = path.getFileName().toString();
            String url = path.getFilePath();

            return new FileDto(filename, url);
        }).collect(Collectors.toList());
        return fileInfos;
    }
}
