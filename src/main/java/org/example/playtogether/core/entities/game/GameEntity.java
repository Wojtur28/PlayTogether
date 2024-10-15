package org.example.playtogether.core.entities.game;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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

    private Set<GameCategory> categories;

    private int onlineGamers;

    @ManyToMany(mappedBy = "gamesPlayed")
    private Set<UserEntity> users;

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", categories=" + categories +
                ", onlineGamers=" + onlineGamers +
                '}';
    }
}
