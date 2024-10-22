package org.example.playtogether.web.dto.comment;

import org.example.playtogether.web.dto.user.UserResponse;

import java.util.UUID;

public record CommentResponse(UUID id,
                              String content,
                              int skillRating,
                              int likes,
                              int toxicityRating,
                              UserResponse writtenFor) {
}

