package com.example.demo.controller;

import com.example.demo.entity.Subgerente;
import com.example.demo.services.JuntaService;
import com.example.demo.services.SubGerenteService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author mijae
 */
@Controller
@RequestMapping("/sg")
public class SubGerenteController {

    //----------------------------------------------- De aca es otra wea
    @Autowired
    private SubGerenteService subgerenteService;

    @GetMapping("/all")
    public String listarSG(Model model) {
        model.addAttribute("organizacion", subgerenteService.readAll());
        return "sg/listarSG";
    }

    @GetMapping("/form")
    public String createSG(Model model) {
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("organizacion", new Subgerente());
        return "sg/formSG";
    }

    @PostMapping("/add")
    public String saveSG(@Valid @ModelAttribute Subgerente sg, BindingResult result, Model model, RedirectAttributes attributes) {
        subgerenteService.create(sg);
        return "redirect:/sg/all";
    }

    @GetMapping("/del/{id}")
    public String deleteSG(Model model, @PathVariable("id") Integer idsg) {
        subgerenteService.delete(idsg);
        return "redirect:/sg/all";
    }

    @GetMapping("/edit/{id}")
    public String editSG(Model model, @PathVariable("id") Integer idsg) {
        Subgerente subgerente = subgerenteService.read(idsg);
        model.addAttribute("titulo", "Modificar ");
        model.addAttribute("organizacion", subgerente);
        return "sg/formSG";
    }

    @PostMapping("/{id}")
    public String readSG(Model model, @PathVariable("id") Integer idsg) {
        model.addAttribute("jd", subgerenteService.read(idsg));
        return "redirect:/sg";
    }

}
