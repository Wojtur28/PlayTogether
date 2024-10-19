package org.example.playtogether.core.usecase.comment;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.comment.CommentEntity;
import org.example.playtogether.core.entities.comment.CommentRepository;
import org.example.playtogether.mapper.CommentMapper;
import org.example.playtogether.web.dto.comment.CommentResponse;
import org.example.playtogether.web.dto.comment.CreateCommentRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCommentUseCase {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentResponse createComment(CreateCommentRequest createCommentRequest) {
        CommentEntity newComment = commentMapper.toEntity(createCommentRequest);

        commentRepository.save(newComment);

        return commentMapper.toCommentResponse(newComment);
    }
}
