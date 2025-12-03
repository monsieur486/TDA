package com.mr486.tda.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    //private final AmiService amiService;
    //private final ContratService contratService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("amis", List.of());
        model.addAttribute("contrats", List.of());
        return "home";
    }
}
