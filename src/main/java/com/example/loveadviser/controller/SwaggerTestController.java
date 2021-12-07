package com.example.loveadviser.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiOperation("조회") //swagger api 리스트에 보여질 이름
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SwaggerTestController {

    @GetMapping("/planner")
    public String getPlanner() {
        String ex = "planner";

        return ex;
    }
}
