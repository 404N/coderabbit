package com.example.coderabbit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @GetMapping(path = "/")
    public String login() {
        return "hello";
    }
}
