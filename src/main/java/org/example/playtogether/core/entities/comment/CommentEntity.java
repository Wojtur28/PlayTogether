package org.example.playtogether.core.entities.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.playtogether.core.entities.BaseEntity;
import org.example.playtogether.core.entities.user.UserEntity;

@EqualsAndHashCode(callSuper = true)
@Entity (name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity extends BaseEntity {

    private String content;

    private int skillRating;

    private int likes;

    private int toxicityRating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity writtenFor;
}
