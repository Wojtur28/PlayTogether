package org.example.playtogether.core.usecase.game;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.game.GameRepository;
import org.example.playtogether.mapper.GameMapper;
import org.example.playtogether.web.dto.game.GameResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class GetGameUseCase {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public GameResponse getGame(UUID gameId) {
        return gameMapper.toGameResponse(gameRepository.findById(gameId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + gameId)));
    }
}
