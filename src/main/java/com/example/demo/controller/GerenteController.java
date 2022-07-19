package com.example.demo.controller;

import com.example.demo.services.JuntaService;
import com.example.demo.services.SubGerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grt")
public class GerenteController {

    @Autowired
    private SubGerenteService subgerenteService;

    @GetMapping("/all")
    public String listarGer(Model model) {
        model.addAttribute("organizacion", subgerenteService.readAll());
        return "grt/listarGer";
    }

}
