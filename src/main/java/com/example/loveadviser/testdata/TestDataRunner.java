package com.example.loveadviser.testdata;

import com.example.loveadviser.dto.ArticleRequestDto;
import com.example.loveadviser.model.Article;
import com.example.loveadviser.model.Comment;
import com.example.loveadviser.model.User;
import com.example.loveadviser.repository.ArticleRepository;
import com.example.loveadviser.repository.CommentRepository;
import com.example.loveadviser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class TestDataRunner implements ApplicationRunner {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 테스트 User 생성
        User testUser1 = new User("pikachu", "pika", passwordEncoder.encode("123"));
        User testUser2 = new User("ggobugi", "ggobug", passwordEncoder.encode("123"));
        User testUser3 = new User("user1", "nick1", passwordEncoder.encode("123"));
        User testUser4 = new User("user2", "nick2", passwordEncoder.encode("123"));
        User testUser5 = new User("user3", "nick3", passwordEncoder.encode("123"));
        User testUser6 = new User("user4", "nick4", passwordEncoder.encode("123"));
        User testUser7 = new User("user5", "nick5", passwordEncoder.encode("123"));
        User testUser8 = new User("user6", "nick6", passwordEncoder.encode("123"));
        User testUser9 = new User("user7", "nick7", passwordEncoder.encode("123"));
        User testUser10 = new User("user8", "nick8", passwordEncoder.encode("123"));
        testUser1 = userRepository.save(testUser1);
        testUser2 = userRepository.save(testUser2);
        testUser3 = userRepository.save(testUser3);
        testUser4 = userRepository.save(testUser4);
        testUser5 = userRepository.save(testUser5);
        testUser6 = userRepository.save(testUser6);
        testUser7 = userRepository.save(testUser7);
        testUser8 = userRepository.save(testUser8);
        testUser9 = userRepository.save(testUser9);
        testUser10 = userRepository.save(testUser10);

        // 테스트 Article 생성
        ArticleRequestDto articleRequestDto1 = new ArticleRequestDto("GreenLight", "그린라이트인가요?", "이거 그린라이트 맞나요?");
        ArticleRequestDto articleRequestDto2 = new ArticleRequestDto("Consulting", "레드라이트인가요?", "이거 레드라이트 맞나요?");
        Article testArticle1 = new Article(testUser1, articleRequestDto1);
        Article testArticle2 = new Article(testUser2, articleRequestDto2);
        testArticle1 = articleRepository.save(testArticle1);
        testArticle2 = articleRepository.save(testArticle2);


        // 테스트 Comment 생성
        Comment comment1 = new Comment(testUser1, testArticle1, "테스트코멘트 1번");
        Comment comment2 = new Comment(testUser1, testArticle1, "테스트코멘트 2번");
        Comment comment3 = new Comment(testUser1, testArticle2, "테스트코멘트 3번");
        Comment comment4 = new Comment(testUser2, testArticle2, "테스트코멘트 4번");
        Comment comment5 = new Comment(testUser2, testArticle2, "테스트코멘트 5번");
        Comment comment6 = new Comment(testUser2, testArticle1, "테스트코멘트 6번");
        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
        commentRepository.save(comment4);
        commentRepository.save(comment5);
        commentRepository.save(comment6);
    }
}