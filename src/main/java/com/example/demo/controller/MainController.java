package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mijae
 */
@Controller
@RequestMapping("/auth/main")
public class MainController {

    @GetMapping
    public String main() {
        return "main";
    }

}
