package org.example.playtogether.web.entrypoint;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.usecase.igdb.GameService;
import org.example.playtogether.web.dto.igdb.Game;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class IgdbController {

    private final GameService gameService;

    @PreAuthorize("permitAll()")
    @MutationMapping
    public List<Game> fetchGames(@Argument int limit, @Argument int offset) {
        return gameService.fetchGames(limit, offset);
    }
}
