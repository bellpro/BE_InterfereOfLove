package com.example.loveadviser.model;

import com.example.loveadviser.dto.ArticleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Count {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long count_id;

    @ManyToOne
    private User user;

    @OneToOne
    private Article article;

    @Column
    private int greenCount;

    @Column
    private int redCount;

    public Count (User user, Article article, int greenCount, int redCount) {
        this.user = user;
        this.article = article;
        this.greenCount = greenCount;
        this.redCount = redCount;
    }

    // 라이트 업데이트
    public void update(int greenCount, int redCount) {
        this.greenCount = greenCount;
        this.redCount = redCount;
    }
}
