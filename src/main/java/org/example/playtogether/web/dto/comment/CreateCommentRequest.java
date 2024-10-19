package org.example.playtogether.web.dto.comment;

import org.example.playtogether.web.dto.user.UserInput;

public record CreateCommentRequest(String content,
                                   int skillRating,
                                   int toxicityRating,
                                   UserInput writtenFor
                                   ) {
}
