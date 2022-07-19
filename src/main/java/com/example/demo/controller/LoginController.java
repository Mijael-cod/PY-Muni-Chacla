/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entity.login;
import com.example.demo.services.loginservice;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author mijae
 */
@Controller

public class LoginController {

    @Autowired
    private loginservice userService;

    @GetMapping("/login")

    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new login());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") login user) {

        login oauthUser = userService.Login(user.getUsername(), user.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {

            return "redirect:/auth/main";

        } else {
            return "redirect:/login";

        }

    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response) {

        return "redirect:/login";
    }

    @PostMapping("/registrar")
    public String saveLog(@Valid @ModelAttribute login log, BindingResult result, Model model, RedirectAttributes attributes) {
        userService.create(log);
        //model.addAttribute("categorias", categoriaService.readAll());
        return "redirect:/formReg";
    }

    @GetMapping("/formReg")
    public String createLog(Model model) {
        model.addAttribute("user", new login());
        return "/login";
    }

}
