package org.example.playtogether.core.usecase.game;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.game.GameRepository;
import org.example.playtogether.mapper.GameMapper;
import org.example.playtogether.web.dto.game.GamesListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetGamesUseCase {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public List<GamesListResponse> getGames() {
        return gameMapper.toGamesListResponse(gameRepository.findAll());
    }
}
