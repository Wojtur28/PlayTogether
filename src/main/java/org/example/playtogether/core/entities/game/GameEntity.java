package org.example.playtogether.core.entities.game;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.playtogether.core.entities.BaseEntity;
import org.example.playtogether.core.entities.user.UserEntity;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameEntity extends BaseEntity {

    private String name;

    @ElementCollection(targetClass = GameCategory.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "game_categories", joinColumns = @JoinColumn(name = "game_id"))
    @Column(name = "game_categories", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<GameCategory> gameCategories;

    private int onlineGamers;

    @ManyToMany(mappedBy = "gamesPlayed")
    private Set<UserEntity> users;

    @Override
    public String toString() {
        return "GameEntity{" +
                "onlineGamers=" + onlineGamers +
                ", gameCategories=" + gameCategories +
                ", name='" + name + '\'' +
                '}';
    }
}
