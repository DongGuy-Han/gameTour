package com.project.gametour.service;

import com.project.gametour.dto.UserResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Transactional
    @Test
    void show_성공_존재하는_id_입력() {
        // 1. 예상 데이터
        Long id = 1L;
        UserResponseDto expected = UserResponseDto.builder()
                .username("홍길동")
                .name("홍길동")
                .reviewList(new ArrayList<>())
                .build();
        // 2. 실제 데이터
        UserResponseDto userResponseDto = userService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), userResponseDto.toString());
    }

    @Test
    void show_실패() {
        // 1. 예상 데이터
        // 2. 실제 데이터
        // 3. 비교 및 검증
    }
}