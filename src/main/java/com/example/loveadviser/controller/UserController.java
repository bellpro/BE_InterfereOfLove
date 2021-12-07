package com.example.loveadviser.controller;

import com.example.loveadviser.dto.SignupRequestDto;
import com.example.loveadviser.service.UserService;
import com.example.loveadviser.validator.UserValidator;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    //회원가입 요청
    @ApiOperation("회원가입 요청")
    @PostMapping("/user/signup")
    private String registerUser( @RequestBody SignupRequestDto signupRequestDto) {
        userService.registerUser(signupRequestDto);

        return "로그인홈페이지";
    }


}


