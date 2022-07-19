package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String start() {
        return "start";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
