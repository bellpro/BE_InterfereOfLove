package com.example.loveadviser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ArticleResponseDto {
    private Long article_id;            // 게시글 ID
    private String type;                // 게시글 유형 (그린, 고민)
    private String nickname;            // 닉네임
    private String title;               // 제목
    private LocalDateTime createDate;   // 생성일자
}
