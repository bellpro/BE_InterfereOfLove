package com.example.loveadviser.dto;

import lombok.Getter;

@Getter
public class ArticleRequestDto {
    private String type;        // 게시글 유형 (그린, 고민)
    private String title;       // 제목
    private String content;     // 내용
}
