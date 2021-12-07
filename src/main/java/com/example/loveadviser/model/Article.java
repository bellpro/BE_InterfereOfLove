package com.example.loveadviser.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Article {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long article_id;

    @ManyToOne
    private User user;

    @Column (nullable = false)
    private String articleType;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false)
    private String content;

}
