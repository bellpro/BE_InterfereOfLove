package com.example.loveadviser.dto;

import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
public class SignupRequestDto {
    @NotNull
    private String username;

    @NotNull
    private String nickname;

    @NotNull
    private String password;

    @NotNull
    private String password2;


}
