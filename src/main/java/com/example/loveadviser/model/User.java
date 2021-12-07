package com.example.loveadviser.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long user_id;

    @Column(nullable = false)
    private String username;

    @Column (nullable = false)
    private String nickname;

    @Column (nullable = false)
    private String password;

    @Builder
    public User(Long user_id, String username, String nickname, String password) {
        this.user_id = user_id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }
}
