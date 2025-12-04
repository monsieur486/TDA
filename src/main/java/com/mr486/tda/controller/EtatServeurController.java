package com.mr486.tda.controller;

import com.mr486.tda.dto.EtatServeur;
import com.mr486.tda.service.EtatServeurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class EtatServeurController {

    private final EtatServeurService etatServeurService;

    @GetMapping(value = "/etat", produces = "application/json")
    public ResponseEntity<EtatServeur> getEtat() {
        return ResponseEntity.ok(etatServeurService.getEtatServeur());
    }
}
