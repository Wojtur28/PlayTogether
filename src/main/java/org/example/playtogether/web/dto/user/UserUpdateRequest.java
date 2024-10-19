package org.example.playtogether.web.dto.user;

import org.example.playtogether.core.entities.comment.CommentEntity;
import org.example.playtogether.core.entities.game.GameEntity;
import org.example.playtogether.core.entities.user.Gender;
import org.example.playtogether.core.entities.user.Language;

import java.util.List;
import java.util.Set;

//TODO: Separate Requests and Responses records for different role: GameResponseAdmin, GameResponseUser...
//TODO: Refactor gamesPlayed and comments type to dto
public record UserUpdateRequest(String username,
                                String email,
                                int toxicityLevel,
                                Gender gender,
                                Set<Language> languageWritten,
                                Set<Language> languageSpoken,
                                Set<GameEntity> gamesPlayed,
                                List<CommentEntity> comments) {
}
