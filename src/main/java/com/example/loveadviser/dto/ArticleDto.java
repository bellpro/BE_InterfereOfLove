package com.example.loveadviser.dto;

import com.example.loveadviser.model.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleDto {
    private Long article_id;            // 게시글 ID
    private String username;
    private String type;                // 게시글 유형 (그린, 고민)
    private String nickname;            // 닉네임
    private String title;               // 제목
    private String createDate;   // 생성일자

    public static List<ArticleDto> listOf(List<Article> articles) {
        List<ArticleDto> articleDtos = new ArrayList<>();


        for (Article article : articles) {
            ArticleDto articleDto = new ArticleDto(
                    article.getArticle_id(),
                    article.getUser().getUsername(),
                    article.getType(),
                    article.getUser().getNickname(),
                    article.getTitle(),
                    article.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            );
            articleDtos.add(articleDto);
        }
        return articleDtos;
    }
}
