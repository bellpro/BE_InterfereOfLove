package com.example.loveadviser.dto;

import com.example.loveadviser.model.Article;
import com.example.loveadviser.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CommentRequestDto {
    private User user;
    private Article article;
    private String comment;

    public CommentRequestDto(User user, Article article, String comm) {
        this.user = user;
        this.article = article;
        this.comment = comm;
    }
}
