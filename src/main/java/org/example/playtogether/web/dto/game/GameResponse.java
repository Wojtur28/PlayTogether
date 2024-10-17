package org.example.playtogether.web.dto.game;

import org.example.playtogether.core.entities.game.GameCategory;

import java.util.Set;
import java.util.UUID;

public record GameResponse(UUID id, String name, int onlineGamers, Set<GameCategory> gameCategories) {
}
