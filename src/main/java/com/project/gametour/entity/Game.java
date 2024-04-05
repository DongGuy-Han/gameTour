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

    private String name;
    private String Introduction; // 소개글
    private String developer;   // 개발사
    private String distributor; // 배급사
    private LocalDateTime releaseDate;  // 출시일

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    private List<Review> reviewList;
}
