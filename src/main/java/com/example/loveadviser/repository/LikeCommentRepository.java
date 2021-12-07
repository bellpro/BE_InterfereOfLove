package com.example.loveadviser.repository;

import com.example.loveadviser.model.Comment;
import com.example.loveadviser.model.LikeComment;
import com.example.loveadviser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {
    List<Comment> findAllByComment(Comment comment);
    Optional<LikeComment> findByUserAndComment(User user, Comment comment);
}
