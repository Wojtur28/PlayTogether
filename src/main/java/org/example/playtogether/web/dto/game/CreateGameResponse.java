package org.example.playtogether.web.dto.game;

import org.example.playtogether.core.entities.game.GameCategory;

import java.util.Set;
import java.util.UUID;

//TODO: Delete this and use GameResponse as a response if these records are the same
public record CreateGameResponse(UUID id,
                                 String name,
                                 int onlineGamers,
                                 Set<GameCategory> gameCategories) {
}

