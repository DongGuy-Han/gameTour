package com.project.gametour.dto;

import com.project.gametour.entity.User;
import com.project.gametour.role.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class UserRequestDto {
    private String username;
    private String password;

    public static User toEntity(UserRequestDto userRequestDto) {
        return User.builder()
                .username(userRequestDto.getUsername())
                .password(userRequestDto.getPassword())
                .name(userRequestDto.getUsername())
                .role(UserRole.USER.getValue())
                .createDate(LocalDateTime.now())
                .build();
    }
}
