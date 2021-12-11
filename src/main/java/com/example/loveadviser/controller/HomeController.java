package com.example.loveadviser.controller;

import com.example.loveadviser.dto.ArticleDto;
import com.example.loveadviser.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private final ArticleService articleService;

    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 모든 게시글 조회
    // 만든 날짜 기준 정렬
    @ApiOperation("모든 게시글 조회")
    @GetMapping("/home")
    public List<ArticleDto> getArticles() {
        return articleService.getArticles();
    }
}