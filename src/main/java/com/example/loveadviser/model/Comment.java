package com.example.loveadviser.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long comment_id;

    @ManyToOne
    private Article article;

    @ManyToOne
    private User user;

    @Column
    private String content;

    @Column
    private Long recommend;
}
