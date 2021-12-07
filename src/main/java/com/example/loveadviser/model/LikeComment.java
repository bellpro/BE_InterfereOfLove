package com.example.loveadviser.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class LikeComment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Comment comment;

    public LikeComment(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }
}
