package org.example.playtogether.core.usecase.igdb;

import lombok.AllArgsConstructor;
import org.example.playtogether.igdb.IgdbClient;
import org.example.playtogether.web.dto.igdb.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {

    private final IgdbClient igdbClient;

    public List<Game> fetchGames(int limit, int offset) {
        return igdbClient.fetchGamesPage(limit, offset);
    }
}
