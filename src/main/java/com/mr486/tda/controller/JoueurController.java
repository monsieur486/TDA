package com.mr486.tda.controller;

import com.mr486.tda.dto.JoueurInscrit;
import com.mr486.tda.service.JoueurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/private")
@RequiredArgsConstructor
public class JoueurController {

    private final JoueurService joueurService;

    @GetMapping(value = "/joueurs", produces = "application/json")
    public ResponseEntity<List<JoueurInscrit>> getJoueurOrder() {
        return ResponseEntity.ok(joueurService.getJoueursInscrits());
    }
}
