package org.example.playtogether.web.entrypoint;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.usecase.comment.CreateCommentUseCase;
import org.example.playtogether.core.usecase.comment.DeleteCommentUseCase;
import org.example.playtogether.core.usecase.comment.GetCommentsFromUserUseCase;
import org.example.playtogether.web.dto.comment.CommentResponse;
import org.example.playtogether.web.dto.comment.CreateCommentRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class CommentController {

    private final CreateCommentUseCase createCommentUseCase;
    private final GetCommentsFromUserUseCase getCommentsFromUserUseCase;
    private final DeleteCommentUseCase deleteCommentUseCase;

    @QueryMapping
    public List<CommentResponse> getCommentsFromUser(@Argument UUID userId) {
        return getCommentsFromUserUseCase.getCommentsFromUser(userId);
    }

    @MutationMapping
    public CommentResponse createComment(@Argument("input") CreateCommentRequest createCommentRequest) {
        return createCommentUseCase.createComment(createCommentRequest);
    }

    @MutationMapping
    public boolean deleteComment(@Argument UUID id) {
        return deleteCommentUseCase.deleteComment(id);
    }
}
