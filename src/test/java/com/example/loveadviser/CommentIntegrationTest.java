package com.example.loveadviser;

import com.example.loveadviser.model.Article;
import com.example.loveadviser.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommentIntegrationTest {

    @Autowired
    private final TestRestTemplate restTemplate;

    private HttpHeaders headers;
    private ObjectMapper mapper = new ObjectMapper();


    private User user1 = User.builder()
            .user_id(1L)
            .username("user1_username")
            .nickname("user1_nickname")
            .password("test123")
            .build();

    private User user2 = User.builder()
            .user_id(2L)
            .username("user2_username")
            .nickname("user2_nickname")
            .password("test123")
            .build();

    private Article article1 = Article.builder()
            .article_id(1L)
            .user(user1)
            .articleType("GreenLight")
            .title("게시글1_타이틀")
            .content("게시글1_내용")
            .build();

    private Article article2 = Article.builder()
            .article_id(2L)
            .user(user2)
            .articleType("Consulting")
            .title("게시글2_타이틀")
            .content("게시글2_내용")
            .build();


    @BeforeEach
    public void setup() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    @Order(1)
    @DisplayName("댓글등록1")
    void commentTest1() throws JsonProcessingException {
        //given
        User user = user1;
        Article article = article1;
        String comm = "댓글1번 테스트중입니다.";

        String requestBody = mapper.writeValueAsString(comm);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        //when
        Long article_id = article.getArticle_id();
        String comment = comm;
        ResponseEntity<Object> response = restTemplate.postForEntity(
                "/api/article/" + article_id + "/comment",
                request,
                Object.class);

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }



    @Builder
    @Setter
    @Getter
    static class User {
        Long user_id;
        String username;
        String nickname;
        String password;
    }

    @Builder
    @Setter
    @Getter
    static class Article {
        Long article_id;
        User user;
        private String articleType;
        private String title;
        private String content;
    }

    @Builder
    @Setter
    @Getter
    static class CommentRequestDto {
        private User user;
        private Article article;
        private String comment;
    }

}
