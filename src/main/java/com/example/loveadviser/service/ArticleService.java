package com.example.loveadviser.service;

import com.example.loveadviser.dto.ArticleDto;
import com.example.loveadviser.dto.ArticleRequestDto;
import com.example.loveadviser.dto.ArticleResponseDto;
import com.example.loveadviser.dto.CommentResponseDto;
import com.example.loveadviser.model.Article;
import com.example.loveadviser.model.Count;
import com.example.loveadviser.model.User;
import com.example.loveadviser.repository.ArticleRepository;
import com.example.loveadviser.repository.CountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CountRepository countRepository;

    //전체 게시글 조회
    public List<ArticleDto> getArticles() {
        //작성날짜기준 내림차순
        List<Article> articles = articleRepository.findAll(Sort.by(Sort.Direction.DESC,"createDate"));
        return ArticleDto.listOf(articles);

    }

    // 게시글 작성
    @Transactional  // 메소드 SQL 쿼리문 선언
    public void createArticle(User user, ArticleRequestDto articleRequestDto) {
        // 인증된 사용자, 클라이언트 요청 DTO 로 DB 저장할 객체 만들기
        Article article = new Article(user, articleRequestDto);

        // 게시글 DB 저장
        articleRepository.save(article);
    }

    // 게시글 상세 조회
    public ArticleResponseDto getArticle(Long article_id) {
        // 선택한 게시글 정보 찾기
        Article article = articleRepository.findById(article_id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 없습니다.")
        );
        String type = article.getType();
        String nickname = article.getUser().getNickname();
        String title = article.getTitle();
        String content = article.getContent();
        LocalDateTime createDate = article.getCreateDate();

        // 그린/레드 라이트 카운트 조회
        int greenCount = (int) countRepository.findAllByArticleAndGreenCount(article, 1).size();
        int redCount = (int) countRepository.findAllByArticleAndRedCount(article, 1).size();

        return new ArticleResponseDto(article_id, type, nickname, title, content, createDate,
                greenCount, redCount);
    }

    // 게시글 수정
    @Transactional  // 메소드 SQL 쿼리문 선언
    public void updateArticle(Long article_id, ArticleRequestDto articleRequestDto) {
        // 선택한 게시글 찾기
        Article article = articleRepository.findById(article_id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );

        // 게시글 DB 업데이트
        article.update(articleRequestDto);
    }

    // 게시글 상세_그린라이트
    @Transactional  // 메소드 SQL 쿼리문 선언
    public void updateGreen(User user, Article article) {
        // 카운트 생성 (사용자 인증, 선택한 게시글, 그린/레드 카운트 0)
        Count count = new Count(user, article, 0, 0);

        Count findCount = countRepository.findByUserAndArticle(user, article);
        // 그린 라이트 체크 여부 확인
        Optional<Count> greenCheck = countRepository.findByUserAndArticleAndGreenCount(user, article, 1);
        // 레드 라이트 체크 여부 확인
        Optional<Count> redCheck = countRepository.findByUserAndArticleAndRedCount(user, article, 1);

        if (!greenCheck.isPresent()) {          // 1. 그린 체크안된 상태면
            if (!redCheck.isPresent()){             // 1) 레드 체크 안된 상태면
                count.setGreenCount(1);                 // 그린 On
                count.setRedCount(0);                   // 레드 Off
                countRepository.save(count);            // Count row 생성
            } else {                                // 2) 레드 체크된 상태면
                findCount.update(1, 0); // 그린 On, 레드 Off
            }
        } else {                                // 2. 그린 체크된 상태면
            countRepository.delete(findCount);          // Count row 삭제
        }
    }

    // 게시글 상세_레드
    @Transactional  // 메소드 SQL 쿼리문 선언
    public void updateRed(User user, Article article) {
        // 카운트 생성 (사용자 인증, 선택한 게시글, 그린/레드 카운트 0)
        Count count = new Count(user, article, 0, 0);

        Count findCount = countRepository.findByUserAndArticle(user, article);

        // 그린 라이트 체크 여부 확인
        Optional<Count> greenCheck = countRepository.findByUserAndArticleAndGreenCount(user, article, 1);
        // 레드 라이트 체크 여부 확인
        Optional<Count> redCheck = countRepository.findByUserAndArticleAndRedCount(user, article, 1);

        if (!redCheck.isPresent()) {          // 1. 레드 체크안된 상태면
            if (!greenCheck.isPresent()){           // 1) 그린 체크 안된 상태면
                count.setGreenCount(0);                 // 그린 Off
                count.setRedCount(1);                   // 레드 On
                countRepository.save(count);            // Count row 생성
            } else {                                // 2) 그린 체크된 상태면
                findCount.update(0, 1); // 그린 Off, 레드 On
            }
        } else {                                // 2. 레드 체크된 상태면
            countRepository.delete(findCount);          // Count row 삭제
        }
    }
}
