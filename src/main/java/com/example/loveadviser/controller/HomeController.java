package com.example.loveadviser.controller;

import com.example.loveadviser.dto.ArticleResponseDto;
import com.example.loveadviser.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ArticleService articleService;

    //게시글 list 조회
    @ApiOperation("모든 게시글 조회")
    @GetMapping("/home")
    public List<ArticleResponseDto> getArticles() {
        return articleService.getArticles();
    }


}