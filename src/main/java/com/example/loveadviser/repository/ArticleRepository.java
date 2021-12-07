package com.example.loveadviser.repository;

import com.example.loveadviser.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
