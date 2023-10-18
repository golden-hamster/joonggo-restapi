package com.study.joonggoapi.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    private String title;

    private String content;

    private Integer price;

    private BoardStatus postStatus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UploadFile> uploadFiles;

    private LocalDateTime createdDate;
}
