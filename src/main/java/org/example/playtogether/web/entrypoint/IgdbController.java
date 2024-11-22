package org.example.playtogether.web.entrypoint;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.usecase.igdb.GameService;
import org.example.playtogether.web.dto.igdb.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/igdb")
public class IgdbController {

    private final GameService gameService;

    @GetMapping("/games")
    public List<Game> fetchGames(@RequestParam(name = "limit", defaultValue = "100") int limit,
                                 @RequestParam(name = "offset", defaultValue = "0") int offset) {
        return gameService.fetchGames(limit, offset);
    }
}
