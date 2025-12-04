package com.mr486.tda.controller;

import com.mr486.tda.service.AmiService;
import com.mr486.tda.service.ContratService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final AmiService amiService;
    private final ContratService contratService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("amis", amiService.getAmisOrder());
        model.addAttribute("contrats", contratService.getContrats());
        return "home";
    }
}
