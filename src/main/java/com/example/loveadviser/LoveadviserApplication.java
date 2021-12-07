package com.example.loveadviser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing ////l
@SpringBootApplication
public class LoveadviserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoveadviserApplication.class, args);
    }

}
