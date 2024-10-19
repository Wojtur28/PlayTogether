package org.example.playtogether.core.usecase.game;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.game.GameRepository;
import org.example.playtogether.mapper.GameMapper;
import org.example.playtogether.web.dto.game.GameResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetGamesUseCase {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public List<GameResponse> getGames() {
        return gameMapper.toGameResponse(gameRepository.findAll());
    }
}
