package org.example.playtogether.core.usecase.comment;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.comment.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class DeleteCommentUseCase {

    private final CommentRepository commentRepository;

    public boolean deleteComment(UUID id) {
        if (commentRepository.findById(id).isPresent()) {
            commentRepository.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Comment not found with id: " + id);
        }
    }
}
