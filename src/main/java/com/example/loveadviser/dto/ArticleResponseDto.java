package com.example.loveadviser.dto;

import com.example.loveadviser.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleResponseDto {
    private Long article_id;            // 게시글 ID
    private String type;                // 게시글 유형 (그린, 고민)
    private String nickname;            // 닉네임
    private String title;               // 제목
    private LocalDateTime createDate;   // 생성일자

    public static List<ArticleResponseDto> listOf(List<Article> articles) {
        List<ArticleResponseDto> articleResponseDtos = new ArrayList<>();

        for (Article article : articles) {
            ArticleResponseDto articleResponseDto = new ArticleResponseDto(
                    article.getArticle_id(),
                    article.getType(),
                    article.getUser().getNickname(),
                    article.getTitle(),
                    article.getCreatedAt()
            );
            articleResponseDtos.add(articleResponseDto);
        }
        return articleResponseDtos;
    }
}
