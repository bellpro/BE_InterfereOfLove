package com.example.loveadviser.repository;

import com.example.loveadviser.model.Article;
import com.example.loveadviser.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 작성일 내림차순 정렬
    List<Comment> findAllByArticleOrderByCreateDateDesc(Article article);

    // 좋아요 수 내림차순 정렬
    List<Comment> findAllByArticleOrderByLikeCountDesc(Article article);
}
