package com.project.gametour.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description; // 소개글
    private String studio;   // 개발사
    private String publisher; // 배급사
    private String platform;
    private LocalDateTime releaseDate;  // 출시일

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    private List<Review> reviewList;
}
