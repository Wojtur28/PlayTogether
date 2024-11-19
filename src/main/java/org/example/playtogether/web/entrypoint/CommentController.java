package org.example.playtogether.web.entrypoint;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.usecase.comment.CreateCommentUseCase;
import org.example.playtogether.core.usecase.comment.DeleteCommentUseCase;
import org.example.playtogether.core.usecase.comment.GetCommentsFromUserUseCase;
import org.example.playtogether.web.dto.comment.CommentResponse;
import org.example.playtogether.web.dto.comment.CreateCommentRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CreateCommentUseCase createCommentUseCase;
    private final GetCommentsFromUserUseCase getCommentsFromUserUseCase;
    private final DeleteCommentUseCase deleteCommentUseCase;

    @GetMapping("/fromUser/{userId}")
    public List<CommentResponse> getCommentsFromUser(@PathVariable UUID userId) {
        return getCommentsFromUserUseCase.getCommentsFromUser(userId);
    }

    @PostMapping
    public CommentResponse createComment(@RequestBody CreateCommentRequest createCommentRequest) {
        return createCommentUseCase.createComment(createCommentRequest);
    }

    @DeleteMapping("/{id}")
    public boolean deleteComment(@PathVariable UUID id) {
        return deleteCommentUseCase.deleteComment(id);
    }
}
