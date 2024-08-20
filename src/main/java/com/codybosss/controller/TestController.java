package com.codybosss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/public/welcome")
    public String publicWelcome() {
        return "Welcome to the public page!";
    }

    @GetMapping("/private/home")
    public String privateHome() {
        return "Welcome to the private home page!";
    }
}
