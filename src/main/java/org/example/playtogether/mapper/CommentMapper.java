package org.example.playtogether.mapper;

import org.example.playtogether.core.entities.comment.CommentEntity;
import org.example.playtogether.web.dto.comment.CommentResponse;
import org.example.playtogether.web.dto.comment.CreateCommentRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentEntity toEntity (CreateCommentRequest createCommentRequest);

    CommentResponse toCommentResponse(CommentEntity commentEntity);

    List<CommentResponse> toCommentResponse(List<CommentEntity> commentEntity);
}
