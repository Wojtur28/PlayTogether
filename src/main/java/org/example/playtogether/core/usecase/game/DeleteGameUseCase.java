package org.example.playtogether.core.usecase.game;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.game.GameRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DeleteGameUseCase {

    private final GameRepository gameRepository;

    public boolean deleteGame(UUID id) {
        gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game not found with id: " + id));

        gameRepository.deleteById(id);
        return true;
    }

}
