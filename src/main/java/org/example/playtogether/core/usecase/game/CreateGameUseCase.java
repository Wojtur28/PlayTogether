package org.example.playtogether.core.usecase.game;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.game.GameEntity;
import org.example.playtogether.core.entities.game.GameRepository;
import org.example.playtogether.mapper.GameMapper;
import org.example.playtogether.web.dto.game.CreateGameRequest;

import org.example.playtogether.web.dto.game.GameResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateGameUseCase {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public GameResponse createGame(CreateGameRequest createGameRequest) {
        GameEntity newGame = gameMapper.toEntity(createGameRequest);
        gameRepository.save(newGame);
        return gameMapper.toGameResponse(newGame);
    }
}
