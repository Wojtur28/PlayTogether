package org.example.playtogether.core.usecase.game;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.game.GameEntity;
import org.example.playtogether.core.entities.game.GameRepository;
import org.example.playtogether.mapper.GameMapper;
import org.example.playtogether.web.dto.game.GameResponse;
import org.example.playtogether.web.dto.game.UpdateGameRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateGameUseCase {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public GameResponse updateGame(UUID id, UpdateGameRequest updateGameRequest) {
        GameEntity updatedGame = gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game not found with id: " + id));

        updatedGame.setName(updateGameRequest.name());
        updatedGame.setOnlineGamers(updateGameRequest.onlineGamers());
        updatedGame.setGameCategories(updateGameRequest.gameCategories());

        updatedGame = gameRepository.save(updatedGame);

        return gameMapper.toGameResponse(updatedGame);
    }
}
