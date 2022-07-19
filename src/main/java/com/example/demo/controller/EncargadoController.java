package com.example.demo.controller;

import com.example.demo.services.JuntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mijae
 */
@Controller
@RequestMapping("/mp")
public class EncargadoController {

    @Autowired
    private JuntaService juntaService;

    @GetMapping("/all")
    public String listarJD(Model model) {
        model.addAttribute("juntadirectiva", juntaService.readAll());
        return "mp/listarMP";
    }

}
