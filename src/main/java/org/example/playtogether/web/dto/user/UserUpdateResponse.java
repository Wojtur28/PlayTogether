package org.example.playtogether.web.dto.user;

import org.example.playtogether.core.entities.game.GameEntity;
import org.example.playtogether.core.entities.user.Gender;
import org.example.playtogether.core.entities.user.Language;

import java.util.Set;

public record UserUpdateResponse(String username,
                                 String email,
                                 int toxicityLevel,
                                 Gender gender,
                                 Set<Language> languageWritten,
                                 Set<Language> languageSpoken,
                                 Set<GameEntity> gamesPlayed) {
}
