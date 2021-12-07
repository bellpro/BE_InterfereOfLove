package com.example.loveadviser.service;

import com.example.loveadviser.dto.UserRequestDto;
import com.example.loveadviser.model.User;
import com.example.loveadviser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRequestDto userRequestDto) {

        String username = userRequestDto.getUsername();
        String nickname = userRequestDto.getNickname();
        String password = userRequestDto.getPassword();
        String password2 = userRequestDto.getPassword2();

        String patternId ="^[a-zA-z0-9]{3,12}$";
        String patternpw= "^.*(?=^.{4,12}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";

        Optional<User> foundName = userRepository.findByUsername(userRequestDto.getUsername());
        Optional<User> foundNick= userRepository.findByNickname(userRequestDto.getNickname());

        if (foundName.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 ID입니다.");
        }

        if(username == null || Pattern.matches(patternId, username)){
            throw new IllegalArgumentException("숫자,문자 포함 3~12자 이내로 입력해주세요.");
        }

        //nickname 확인
        if (foundNick.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 닉네임입니다.");
        }

        if (nickname.length() > 10) {
            throw new IllegalArgumentException("닉네임은 10자 이내로 작성하세요.");
        }

        //비밀번호 확인
        if (password == null || Pattern.matches(patternpw, password)) {
            throw new IllegalArgumentException("숫자,문자,특수문자 포함 4~12자 이내로 입력해주세요.");
        }

        if (!password.equals(password2)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        //패스워드 암호화
        String encodePassword = passwordEncoder.encode(password);

        User user = User.builder()
                .username(username)
                .nickname(nickname)
                .password(encodePassword)
                .build();

        userRepository.save(user);

    }

    }
