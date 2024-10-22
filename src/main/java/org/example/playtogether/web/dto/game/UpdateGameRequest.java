package org.example.playtogether.web.dto.game;

import org.example.playtogether.core.entities.game.GameCategory;

import java.util.Set;

public record UpdateGameRequest(String name,
                                int onlineGamers,
                                Set<GameCategory> gameCategories) {
}
