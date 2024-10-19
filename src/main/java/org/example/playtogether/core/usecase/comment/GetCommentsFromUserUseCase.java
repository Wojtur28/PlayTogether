package org.example.playtogether.core.usecase.comment;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.comment.CommentRepository;
import org.example.playtogether.core.entities.user.UserEntity;
import org.example.playtogether.core.entities.user.UserRepository;
import org.example.playtogether.mapper.CommentMapper;
import org.example.playtogether.web.dto.comment.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GetCommentsFromUserUseCase {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final UserRepository userRepository;

    public List<CommentResponse> getCommentsFromUser(UUID userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found with id: " + userId)
        );

        return commentMapper.toCommentResponse(commentRepository.findByWrittenFor(user));
    }
}
