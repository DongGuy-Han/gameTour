package com.project.gametour.controller;

import com.project.gametour.dto.UserRequestDto;
import com.project.gametour.dto.UserResponseDto;
import com.project.gametour.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto created = userService.create(userRequestDto);

        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> show(@PathVariable Long id) {
        UserResponseDto searched = userService.show(id);

        return (searched != null) ?
                ResponseEntity.status(HttpStatus.OK).body(searched) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto updated = userService.update(id, userRequestDto);

        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
