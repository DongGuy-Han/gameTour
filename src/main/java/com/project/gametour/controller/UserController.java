package com.project.gametour.controller;

import com.project.gametour.dto.UserDto;
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
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        UserDto created = userService.create(userDto);

        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> search(@PathVariable Long id) {
        UserDto searched = userService.search(id);

        return (searched != null) ?
                ResponseEntity.status(HttpStatus.OK).body(searched) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
