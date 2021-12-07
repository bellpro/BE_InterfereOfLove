package com.example.loveadviser.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@Setter
@Getter
public class CommentResponseDto {
    private Long comment_id;
    private String nickname;
    private String comment;
    private Long likeCommentCount;
    private LocalDateTime createDate;

    public CommentResponseDto(Long comment_id, String nickname, String comment, Long likeCommentCount, LocalDateTime createDate) {
        this.comment_id = comment_id;
        this.nickname = nickname;
        this.comment = comment;
        this.likeCommentCount = likeCommentCount;
        this.createDate = createDate;
    }
}