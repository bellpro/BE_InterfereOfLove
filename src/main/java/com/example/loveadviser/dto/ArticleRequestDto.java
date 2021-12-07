package com.example.loveadviser.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ArticleRequestDto {
    private String type;        // 게시글 유형 (그린, 고민)
    private String title;       // 제목
    private String content;     // 내용

    public ArticleRequestDto(String type, String title, String content) {
        this.type = type;
        this.title = title;
        this.content = content;
    }
}
