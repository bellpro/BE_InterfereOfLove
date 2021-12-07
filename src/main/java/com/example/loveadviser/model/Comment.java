package com.example.loveadviser.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long comment_id;

    @ManyToOne
    private Article article;

    @ManyToOne
    private User user;

    @Column (nullable = false)
    private String content;

    @Column
    private Long recommend;


    // 코멘트 기본 생성자 생성
    public Comment(User user, Article article, String content) {
        this.user = user;
        this.article = article;
        this.content = content;
    }
}