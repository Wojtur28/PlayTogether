package org.example.playtogether.web.dto.user;


import org.example.playtogether.core.entities.user.Gender;
import org.example.playtogether.core.entities.user.Language;
import org.example.playtogether.web.dto.comment.CommentResponse;
import org.example.playtogether.web.dto.game.GameResponse;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record UserResponse(UUID id,
                           String username,
                           String email,
                           int toxicityLevel,
                           Gender gender,
                           Set<Language> languageWritten,
                           Set<Language> languageSpoken,
                           Set<GameResponse> gamesPlayed,
                           List<CommentResponse> comments) {
}
