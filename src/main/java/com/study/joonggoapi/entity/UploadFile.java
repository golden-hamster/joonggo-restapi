package com.study.joonggoapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
public class UploadFile {

    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    private String originalName;

    private String storedName;

    private LocalDateTime createdDate;
}
