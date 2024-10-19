package org.example.playtogether.web.dto.comment;

import org.example.playtogether.web.dto.user.UserInput;

public record CommentResponse(String content,
                              int skillRating,
                              int likes,
                              int toxicityRating,
                              UserInput writtenFor) {
}
