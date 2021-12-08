package com.example.loveadviser.repository;

import com.example.loveadviser.model.Article;
import com.example.loveadviser.model.Count;
import com.example.loveadviser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountRepository extends JpaRepository<Count, Long> {
    Count findByUserAndArticle(User user, Article article);

    // 사용자 인증, 게시글 선택, 그린 체크 여부
    Optional<Count> findByUserAndArticleAndGreenCount(User user, Article article, int greenCount);
    // 사용자 인증, 게시글 선택, 레드 체크 여부
    Optional<Count> findByUserAndArticleAndRedCount(User user, Article article, int redCount);

    // 선택한 게시글의 그린 리스트 -> size() 로 개수 카운트
    List<Count> findAllByArticleAndGreenCount(Article article, int greenCount);
    // 선택한 게시글의 레드 리스트 -> size() 로 개수 카운트
    List<Count> findAllByArticleAndRedCount(Article article, int redCount);
}
