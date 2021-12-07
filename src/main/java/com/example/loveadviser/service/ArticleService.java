package com.example.loveadviser.service;

import com.example.loveadviser.dto.ArticleRequestDto;
import com.example.loveadviser.dto.ArticleResponseDto;
import com.example.loveadviser.model.Article;
import com.example.loveadviser.model.User;
import com.example.loveadviser.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    //전체 게시글 조회
    public List<ArticleResponseDto> getArticles() {
        //작성날짜기준 내림차순
        List<Article> articles = articleRepository.findAll(Sort.by(Sort.Direction.DESC,"createDate"));
        return ArticleResponseDto.listOf(articles);

    }

    @Transactional  // 메소드 SQL 쿼리문 선언
    public void createArticle(User user, ArticleRequestDto articleRequestDto) {
        // 인증된 사용자, 클라이언트 요청 DTO 로 DB 저장할 객체 만들기
        Article article = new Article(user, articleRequestDto);

        // 게시글 DB 저장
        articleRepository.save(article);
    }

    public ArticleResponseDto getArticle(Long article_id) {
        // 선택한 게시글 정보 찾기
        Article article = articleRepository.findById(article_id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 없습니다.")
        );

        // Response 형식에 맞춰서 리턴
        return new ArticleResponseDto(article.getArticle_id(), article.getType(),
                article.getUser().getNickname(), article.getTitle(), article.getCreatedAt());
    }

    @Transactional  // 메소드 SQL 쿼리문 선언
    public void updateArticle(Long article_id, ArticleRequestDto articleRequestDto) {
        // 선택한 게시글 찾기
        Article article = articleRepository.findById(article_id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );

        // 게시글 DB 업데이트
        article.update(articleRequestDto);
    }
}
