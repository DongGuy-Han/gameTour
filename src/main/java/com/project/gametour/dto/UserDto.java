package com.project.gametour.dto;

import com.project.gametour.entity.Review;
import com.project.gametour.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private String name;
    private String email;
    private List<Review> reviewList;

    public static User toEntity(UserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .role("admin")
                .createDate(LocalDateTime.now())
                .build();
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .reviewList(user.getReviewList())
                .build();
    }
}
