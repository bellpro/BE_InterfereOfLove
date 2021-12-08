package com.example.loveadviser.controller;

import com.example.loveadviser.dto.ArticleDto;
import com.example.loveadviser.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ArticleService articleService;

    //게시글 list 조회
    @ApiOperation("모든 게시글 조회")
    @GetMapping("/home")
    public List<ArticleDto> getArticles() {
        return articleService.getArticles();
    }


}