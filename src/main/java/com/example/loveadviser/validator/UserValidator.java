package com.example.loveadviser.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class UserValidator {

    public static void validateUserRegister(
            String username,
            String nickname,
            String password,
            String password2
    ) {
        String patternId = "^[a-z0-9]{3,12}$";
        String patternpw= "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{4,12}$";

        //아이디 검사
        if(username == null || !Pattern.matches(patternId, username)){
            throw new IllegalArgumentException("숫자,영문 포함하여 3~12자 이내로 입력해주세요.");
        }

        //닉네임 검사
        if (nickname == null || nickname.length() > 10) {
            throw new IllegalArgumentException("닉네임은 10자 이내로 입력하세요.");
        }

        //비밀번호 확인
        if (password == null || !Pattern.matches(patternpw, password)) {
            throw new IllegalArgumentException("숫자,문자,특수문자 포함하여 4~12자 이내로 입력해주세요.");
        }

        if (!password.equals(password2)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
