package com.example.loveadviser.dto;

import java.time.LocalDateTime;
import java.util.Optional;

public class CommentResponseDto {
    private Long comment_id;
    private String nickname;
    private String comment;
    private Optional<Long> likeCommentCount;
    private LocalDateTime createAt;

    public CommentResponseDto(Long comment_id, String nickname, String comment, Optional<Long> likeCommentCount, LocalDateTime createAt) {
        this.comment_id = comment_id;
        this.nickname = nickname;
        this.comment = comment;
        this.likeCommentCount = likeCommentCount;
        this.createAt = createAt;
    }
}