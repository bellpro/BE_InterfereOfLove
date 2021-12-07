package com.example.loveadviser.model;

import com.example.loveadviser.dto.ArticleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Article extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long article_id;

    @ManyToOne
    private User user;

    @Column (nullable = false)
    private String type;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false)
    private String content;

    // 인증된 사용자, 클라이언트 요청 DTO 로 DB 저장할 객체 만들기
    public Article (User user, ArticleRequestDto articleRequestDto) {
        this.user = user;
        this.type = articleRequestDto.getType();
        this.title = articleRequestDto.getTitle();
        this.content = articleRequestDto.getContent();
    }


    // 클라이언트 요청 DTO 로 DB 업데이트
    public void update(ArticleRequestDto articleRequestDto) {
        this.title = articleRequestDto.getTitle();
        this.content = articleRequestDto.getContent();
    }
}
