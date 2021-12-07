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
    private Long likeCount;


    // 코멘트 생성자
    public Comment(User user, Article article, String content) {
        this.user = user;
        this.article = article;
        this.content = content;
        this.likeCount = 0L;
    }
}