package com.project.gametour.service;

import com.project.gametour.dto.UserDto;
import com.project.gametour.entity.User;
import com.project.gametour.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto create(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        User user = UserDto.toEntity(userDto);

        User created = userRepository.save(user);

        return UserDto.toDto(created);
    }

    public UserDto search(Long id) {
        User searched = userRepository.findById(id).orElse(null);

        return (searched != null) ?
                UserDto.toDto(searched) :
                null;
    }
}
