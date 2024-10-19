package org.example.playtogether.mapper;

import org.example.playtogether.core.entities.game.GameEntity;
import org.example.playtogether.web.dto.game.CreateGameRequest;
import org.example.playtogether.web.dto.game.CreateGameResponse;
import org.example.playtogether.web.dto.game.GameResponse;
import org.example.playtogether.web.dto.game.GamesListResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameResponse toGameResponse(GameEntity gameEntity);

    GameEntity toEntity(CreateGameRequest createGameRequest);

    List<GamesListResponse> toGamesListResponse(List<GameEntity> gameEntities);

    CreateGameResponse toCreateGameResponse(GameEntity gameEntity);
}