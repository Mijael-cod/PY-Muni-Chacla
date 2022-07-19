package com.example.demo.controller;

import com.example.demo.entity.Junta;
import com.example.demo.services.JuntaService;
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
@RequestMapping("/jd")
public class JuntaController {

    @Autowired
    private JuntaService juntaService;

    @GetMapping("/all")
    public String listarJD(Model model) {
        model.addAttribute("juntadirectiva", juntaService.readAll());
        return "jd/listarJD";
    }

    @GetMapping("/form")
    public String createJD(Model model) {
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("juntadirectiva", new Junta());
        return "jd/formJD";
    }

    @PostMapping("/add")
    public String saveJD(@Valid @ModelAttribute Junta jd, BindingResult result, Model model, RedirectAttributes attributes) {
        juntaService.create(jd);
        return "redirect:/jd/all";
    }

    @GetMapping("/del/{id}")
    public String deleteJD(Model model, @PathVariable("id") Integer idjd) {
        juntaService.delete(idjd);
        return "redirect:/jd/all";
    }

    @GetMapping("/edit/{id}")
    public String editJD(Model model, @PathVariable("id") Integer idjd) {
        Junta junta = juntaService.read(idjd);
        model.addAttribute("titulo", "Modificar ");
        model.addAttribute("juntadirectiva", junta);
        return "jd/formJD";
    }

    @PostMapping("/{id}")
    public String readJD(Model model, @PathVariable("id") Integer idjd) {
        model.addAttribute("jd", juntaService.read(idjd));
        return "redirect:/jd";
    }

}
