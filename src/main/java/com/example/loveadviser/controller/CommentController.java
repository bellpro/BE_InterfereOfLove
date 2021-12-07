package com.example.loveadviser.controller;

import com.example.loveadviser.dto.CommentRequestDto;
import com.example.loveadviser.dto.CommentResponseDto;
import com.example.loveadviser.model.Article;
import com.example.loveadviser.model.Comment;
import com.example.loveadviser.model.User;
import com.example.loveadviser.repository.ArticleRepository;
import com.example.loveadviser.repository.CommentRepository;
import com.example.loveadviser.security.UserDetailsImpl;
import com.example.loveadviser.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    // 게시글에 대한 모든 댓글 조회하기
    @ApiOperation("모든 댓글 조회하기") //swagger api 리스트에 보여질 이름
    @GetMapping("/api/article/{article_id}/comment")
    public List<CommentResponseDto> getComments(@PathVariable Long article_id) {
        return commentService.getAllComments(article_id);
    }

    // 댓글 작성하기
    @ApiOperation("댓글 작성하기") //swagger api 리스트에 보여질 이름
    @PostMapping("/api/article/{article_id}/comment")
    public void saveComments(@PathVariable Long article_id, @RequestBody String comment, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        String comm = comment;
        Article article = articleRepository.findById(article_id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다.."));
        CommentRequestDto requestDto = new CommentRequestDto(user, article, comm);
        commentService.save(requestDto);
    }

    // 댓글 삭제하기
    @ApiOperation("댓글 삭제하기") //swagger api 리스트에 보여질 이름
    @DeleteMapping("/api/article/{article_id}/commnet/{comment_id}")
    public void deleteComment(@PathVariable Long comment_id) {
        Comment comment = commentRepository.findById(comment_id)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));
        commentRepository.delete(comment);
    }

    // 댓글 좋아요 토글
    @ApiOperation("댓글 좋아요 토글") //swagger api 리스트에 보여질 이름
    @PostMapping("/api/article/{article_id}/{comment_id}/like")
    public void updateLike(@PathVariable Long comment_id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        Comment comment = commentRepository.findById(comment_id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 댓글이 없습니다."));
        commentService.updateLike(comment, user);
    }
}
