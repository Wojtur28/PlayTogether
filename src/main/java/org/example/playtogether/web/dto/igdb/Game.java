package org.example.playtogether.web.dto.igdb;

import java.util.List;

public record Game(
        Long id,
        String name,
        List<Genre> genres,
        List<Platform> platforms,
        List<Theme> themes,
        List<Screenshot> screenshots,
        Double rating
) {

    public record Genre(
            Integer id,
            String name
    ) {}

    public record Platform(
            Integer id,
            String name
    ) {}

    public record Theme(
            Integer id,
            String name
    ) {}

    public record Screenshot(
            Integer id,
            String imageId
    ) {}
}
