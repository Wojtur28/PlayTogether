package org.example.playtogether.web.dto.comment;

import org.example.playtogether.web.dto.user.UserResponse;

public record CreateCommentRequest(String content,
                                   int skillRating,
                                   int toxicityRating,
                                   UserResponse writtenFor) {
}
