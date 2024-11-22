package org.example.playtogether.web.entrypoint;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.playtogether.core.usecase.game.*;
import org.example.playtogether.web.dto.game.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/games")
public class GameController {

    private final GetGamesUseCase getGamesUseCase;
    private final GetGameUseCase getGameUseCase;
    private final CreateGameUseCase createGameUseCase;
    private final UpdateGameUseCase updateGameUseCase;
    private final DeleteGameUseCase deleteGameUseCase;

    @GetMapping
    public List<GameResponse> getGames() {
        return getGamesUseCase.getGames();
    }

    @GetMapping("/{id}")
    public GameResponse getGame(@PathVariable UUID id) {
        return getGameUseCase.getGame(id);
    }

    @PostMapping
    public GameResponse createGame(@RequestBody CreateGameRequest createGameRequest) {
        return createGameUseCase.createGame(createGameRequest);
    }

    @PutMapping("/{id}")
    public GameResponse updateGame(@PathVariable UUID id, @RequestBody UpdateGameRequest updateGameRequest) {
        return updateGameUseCase.updateGame(id, updateGameRequest);
    }

    @DeleteMapping("/{id}")
    public boolean deleteGame(@PathVariable UUID id) {
        return deleteGameUseCase.deleteGame(id);
    }
}
