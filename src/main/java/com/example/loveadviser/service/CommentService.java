package com.example.loveadviser.service;

import com.example.loveadviser.dto.CommentRequestDto;
import com.example.loveadviser.dto.CommentResponseDto;
import com.example.loveadviser.model.Article;
import com.example.loveadviser.model.Comment;
import com.example.loveadviser.model.LikeComment;
import com.example.loveadviser.model.User;
import com.example.loveadviser.repository.ArticleRepository;
import com.example.loveadviser.repository.CommentRepository;
import com.example.loveadviser.repository.LikeCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final LikeCommentRepository likeCommentRepository;

    // 해당 게시글에 대한 모든 댓글 불러오기
    public List<CommentResponseDto> getAllComments(Long article_id) {
        Article article = articleRepository.findById(article_id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
        List<Comment> commentList = commentRepository.findAllByArticleOrderByLikeCountDesc(article);
        List<CommentResponseDto> comments = new ArrayList<>();
        for (Comment com : commentList) {
            Long comment_id = com.getComment_id();
            String nickname = com.getUser().getNickname();
            String comment = com.getContent();
            LocalDateTime createAt = com.getCreateDate();

            Long likeCommentCount = (long)likeCommentRepository.findAllByComment(com).size();
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment_id, nickname, comment, likeCommentCount, createAt);
            comments.add(commentResponseDto);
        }
        return comments;
    }

    // 댓글 저장하기
    public void save(CommentRequestDto requestDto) {
        User user = requestDto.getUser();
        Article article = requestDto.getArticle();
        String comm = requestDto.getComment();
        Comment comment = new Comment(user, article, comm);
        commentRepository.save(comment);
    }

    // 댓글 좋아요 토글
    @Transactional
    public void updateLike(Comment comment, User user){
        LikeComment likeComment = new LikeComment(user, comment);
        Optional<LikeComment> likeCommentCheck = likeCommentRepository.findByUserAndComment(user, comment);
        if (!likeCommentCheck.isPresent()) {
            likeCommentRepository.save(likeComment);
            comment.setLikeCount(comment.getLikeCount()+1);
        } else {
            likeCommentRepository.delete(likeComment);
            comment.setLikeCount(comment.getLikeCount()-1);
        }
    }
}
