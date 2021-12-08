package com.example.loveadviser.controller;

import com.example.loveadviser.dto.ArticleRequestDto;
import com.example.loveadviser.dto.ArticleResponseDto;
import com.example.loveadviser.model.Article;
import com.example.loveadviser.model.Comment;
import com.example.loveadviser.model.User;
import com.example.loveadviser.repository.ArticleRepository;
import com.example.loveadviser.security.UserDetailsImpl;
import com.example.loveadviser.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleRepository articleRepository;

    // 게시글 작성 (게시글 작성 페이지)
    @ApiOperation("게시글 작성하기") //swagger api 리스트에 보여질 이름
    @PostMapping("/api/article")
    public void createArticle (@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody ArticleRequestDto articleRequestDto) {
        // 인증된 사용자 객체, 클라이언트 요청 DTO 전달
        articleService.createArticle(userDetails.getUser(), articleRequestDto);
    }

    // 게시글 조회 (게시글 상세 페이지)
    @ApiOperation("게시글 상세 조회하기") //swagger api 리스트에 보여질 이름
    @GetMapping("/api/article/{article_id}")
    public ArticleResponseDto getArticle (@PathVariable Long article_id) {
        return articleService.getArticle(article_id);
    }


    // 게시글 수정 (게시글 상세 페이지)
    @ApiOperation("게시글 수정하기") //swagger api 리스트에 보여질 이름
    @PutMapping("/api/article/{article_id}")
    public Long updateArticle (@PathVariable Long article_id, @RequestBody ArticleRequestDto articleRequestDto) {
        // 선택한 게시글, 클라이언트 요청 DTO 전달
        articleService.updateArticle(article_id, articleRequestDto);
        return article_id;
    }

    // 게시글 삭제 (게시글 상세 페이지)
    @ApiOperation("게시글 삭제하기") //swagger api 리스트에 보여질 이름
    @DeleteMapping("/api/article/{article_id}")
    public Long deleteArticle (@PathVariable Long article_id) {
        // 선택한 게시글 삭제
        articleRepository.deleteById(article_id);
        return article_id;
    }

    // 그린 라이트 체크
    @ApiOperation("그린 라이트") //swagger api 리스트에 보여질 이름
    @PostMapping("/api/article/{article_id}/green")
    public void updateGreen (@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long article_id) {
        User user = userDetails.getUser();
        Article article = articleRepository.findById(article_id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 게시글이 없습니다."));
        articleService.updateGreen(user, article);
    }

    // 레드 라이트 체크
    @ApiOperation("레드 라이트") //swagger api 리스트에 보여질 이름
    @PostMapping("/api/article/{article_id}/red")
    public void updateRed (@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long article_id) {
        User user = userDetails.getUser();
        Article article = articleRepository.findById(article_id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 게시글이 없습니다."));
        articleService.updateRed(user, article);
    }
}
