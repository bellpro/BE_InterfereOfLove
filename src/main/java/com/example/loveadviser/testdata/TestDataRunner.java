//package com.example.loveadviser.testdata;
//
//import com.example.loveadviser.dto.ArticleRequestDto;
//import com.example.loveadviser.model.Article;
//import com.example.loveadviser.model.User;
//import com.example.loveadviser.repository.ArticleRepository;
//import com.example.loveadviser.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//@RequiredArgsConstructor
//@Component
//public class TestDataRunner implements ApplicationRunner {
//
//    UserRepository userRepository;
//    ArticleRepository articleRepository;
//    BCryptPasswordEncoder passwordEncoder;
//
//    @Transactional
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        // 테스트 User 생성
//        User testUser1 = new User(1L, "pikachu", "pika", passwordEncoder.encode("123"));
//        User testUser2 = new User(2L, "ggobugi", "ggobug", passwordEncoder.encode("123"));
//        testUser1 = userRepository.save(testUser1);
//        testUser2 = userRepository.save(testUser2);
//
//        // 테스트 Article 생성
//        ArticleRequestDto articleRequestDto1 = new ArticleRequestDto("GreenLight", "그린라이트인가요?", "이거 그린라이트 맞나요?");
//        ArticleRequestDto articleRequestDto2 = new ArticleRequestDto("Consulting", "레드라이트인가요?", "이거 레드라이트 맞나요?");
//        Article testArticle1 = new Article(testUser1, articleRequestDto1);
//        Article testArticle2 = new Article(testUser2, articleRequestDto2);
//        testArticle1 = articleRepository.save(testArticle1);
//        testArticle2 = articleRepository.save(testArticle2);
//    }
//}