package org.example.playtogether.mapper;

import org.example.playtogether.core.entities.game.GameEntity;
import org.example.playtogether.web.dto.game.CreateGameRequest;
import org.example.playtogether.web.dto.game.GameResponse;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameResponse toGameResponse(GameEntity gameEntity);

    GameEntity toEntity(CreateGameRequest createGameRequest);

    List<GameResponse> toGameResponse(List<GameEntity> gameEntities);

    Set<GameEntity> toEntity(Set<GameResponse> createGameRequest);
}
