package com.example.loveadviser.controller;

import com.example.loveadviser.dto.UserRequestDto;
import com.example.loveadviser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    //회원가입 페이지
//    @GetMapping("/user/signup")
//    private String showSignup() {
//        return "signUp.html";
//    }

    //회원가입 요청
    @PostMapping("/user/signup")
    @ResponseBody
    private String registerUser(@RequestBody UserRequestDto userRequestDto) {
        userService.registerUser(userRequestDto);
        return "/user/login";
    }
}

