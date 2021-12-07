package com.example.loveadviser.repository;

import com.example.loveadviser.model.Article;
import com.example.loveadviser.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByArticleOrderByCreatedAtDesc(Article article);
}
