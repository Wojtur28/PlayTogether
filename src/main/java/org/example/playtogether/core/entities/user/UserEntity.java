package org.example.playtogether.core.entities.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.playtogether.core.entities.BaseEntity;
import org.example.playtogether.core.entities.comment.CommentEntity;
import org.example.playtogether.core.entities.game.GameEntity;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    private String username;

    private String email;

    private String password;

    private int toxicityLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender", nullable = false)
    private Gender gender;

    @ElementCollection(targetClass = Language.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_language_written", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user_language_written", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Language> languageWritten;

    @ElementCollection(targetClass = Language.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_language_spoken", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user_language_spoken", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Language> languageSpoken;

    @ManyToMany
    @JoinTable(
            name = "user_game",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private Set<GameEntity> gamesPlayed;

    @OneToMany(mappedBy = "writtenFor", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", toxicityLevel=" + toxicityLevel +
                '}';
    }
}
