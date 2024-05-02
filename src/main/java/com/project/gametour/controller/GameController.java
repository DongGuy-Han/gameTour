package com.project.gametour.controller;

import com.project.gametour.entity.Game;
import com.project.gametour.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GameController {
    private final GameService gameService;

    @GetMapping("/games")
    public ResponseEntity<Page<Game>> list(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "kw", defaultValue = "") String kw) {
        Page<Game> searched = gameService.list(page, kw);

        return (searched != null) ?
                ResponseEntity.status(HttpStatus.OK).body(searched) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
