package com.example.loveadviser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaAuditing
@SpringBootApplication
public class LoveadviserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoveadviserApplication.class, args);
    }

}
