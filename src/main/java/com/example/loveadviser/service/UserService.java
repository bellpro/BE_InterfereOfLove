package com.example.loveadviser.service;

import com.example.loveadviser.dto.SignupRequestDto;
import com.example.loveadviser.model.User;
import com.example.loveadviser.repository.UserRepository;
import com.example.loveadviser.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(SignupRequestDto signupRequestDto) {

        String username = signupRequestDto.getUsername();
        String nickname = signupRequestDto.getNickname();
        String password = signupRequestDto.getPassword();
        String password2 = signupRequestDto.getPassword2();

        //중복 검사
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("이미 존재하는 ID입니다.");
        }

        if (userRepository.existsByNickname(nickname)) {
            throw new IllegalArgumentException("이미 존재하는 닉네임입니다.");
        }

        UserValidator.validateUserRegister(username, nickname, password, password2);

        //패스워드 암호화
        String encodePassword = passwordEncoder.encode(password);

        //유저생성
        User user = new User(signupRequestDto, encodePassword);
        userRepository.save(user);

    }

}
