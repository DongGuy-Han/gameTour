package com.project.gametour.service;

import com.project.gametour.entity.Game;
import com.project.gametour.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;

    public Page<Game> list(int page, String kw) {
        Pageable pageable = PageRequest.of(page, 1);
        Page<Game> gameList = gameRepository.findAllByKeyword(kw, pageable);
        if (gameList == null) {
            return null;
        }

        return gameList;
    }
}
