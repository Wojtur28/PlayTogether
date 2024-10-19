package org.example.playtogether.web.entrypoint;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.playtogether.core.usecase.game.*;
import org.example.playtogether.web.dto.game.*;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@AllArgsConstructor
public class GameController {

    private final GetGamesUseCase getGamesUseCase;
    private final GetGameUseCase getGameUseCase;
    private final CreateGameUseCase createGameUseCase;
    private final UpdateGameUseCase updateGameUseCase;
    private final DeleteGameUseCase deleteGameUseCase;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @QueryMapping
    public List<GamesListResponse> getGames() {
        return getGamesUseCase.getGames();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @QueryMapping
    public GameResponse getGame(@Argument UUID id) {
        return getGameUseCase.getGame(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @MutationMapping
    public CreateGameResponse createGame(@Argument("input") CreateGameRequest createGameRequest) {
        return createGameUseCase.createGame(createGameRequest);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @MutationMapping
    public GameResponse updateGame(@Argument UUID id, @Argument("input") UpdateGameRequest updateGameRequest) {
        return updateGameUseCase.updateGame(id, updateGameRequest);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @MutationMapping
    public boolean deleteGame(@Argument UUID id) {
        return deleteGameUseCase.deleteGame(id);
    }
}
