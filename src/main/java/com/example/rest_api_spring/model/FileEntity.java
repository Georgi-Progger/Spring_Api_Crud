package com.example.rest_api_spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;


@Entity
@Table(name = "files")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;

    @LastModifiedDate
    @Column(name = "updated")
    @Temporal(TemporalType.DATE)
    private Date updated;

    @Column(name = "filename")
    private String fileName;

    @Column(name = "filepath")
    private String filePath;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;



}
